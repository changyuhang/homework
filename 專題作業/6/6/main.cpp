#include <opencv/cv.h>
#include <opencv/highgui.h>
#include <iostream>
#include <cmath>
#define pi 3.14159265
using namespace std;
void onMouse(int event, int x, int y, int flags, void* param);
IplImage *Image_original, *Image_gray;
CvPoint point;
int key = 0;
int main() {
    Image_original = cvLoadImage("/Users/yuhang/Desktop/test1/test1/1.jpg", 1);
    Image_gray = cvLoadImage("/Users/yuhang/Desktop/test1/test1/1.jpg", 0);
    
    cvShowImage("mouse_test", Image_original);
    
    cvSetMouseCallback("mouse_test", onMouse, NULL);
    
    cvWaitKey(0);
}
void onMouse(int event, int x, int y, int flag, void* param) {
    if (event == CV_EVENT_LBUTTONDOWN || event == CV_EVENT_RBUTTONDOWN) {
        point = cvPoint(x, y);
        printf("(x:%d,y:%d)", x, y);
        printf("(Blue:%d,Green:%d,Red:%d)\n", uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3)]), uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3) + 1]), uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3) + 2]));
        uchar Neighbor_pixel[8] = {}, gradient_x, gradient_y;
        Neighbor_pixel[0] = Image_gray->imageData[Image_gray->widthStep*(y - 2)+x - 1];
        Neighbor_pixel[1] = Image_gray->imageData[Image_gray->widthStep*(y - 2)+x];
        Neighbor_pixel[2] = Image_gray->imageData[Image_gray->widthStep*(y - 2)+x + 1];
        Neighbor_pixel[3] = Image_gray->imageData[Image_gray->widthStep*(y-1)+x - 1];
        Neighbor_pixel[4] = Image_gray->imageData[Image_gray->widthStep*(y-1)+x + 1];
        Neighbor_pixel[5] = Image_gray->imageData[Image_gray->widthStep*(y)+x - 1];
        Neighbor_pixel[6] = Image_gray->imageData[Image_gray->widthStep*(y)+x];
        Neighbor_pixel[7] = Image_gray->imageData[Image_gray->widthStep*(y)+x + 1];
        gradient_x = abs((Neighbor_pixel[2] + Neighbor_pixel[4] * 2 + Neighbor_pixel[7]) - (Neighbor_pixel[0] + Neighbor_pixel[3] * 2 + Neighbor_pixel[5]));
        gradient_y = abs((Neighbor_pixel[5] + Neighbor_pixel[6] * 2 + Neighbor_pixel[7]) - (Neighbor_pixel[0] + Neighbor_pixel[1] * 2 + Neighbor_pixel[2]));
        double theta = atan2(gradient_y, gradient_x) * 180 / pi;
        printf("%d %d 角度:%.2lf\n", gradient_y, gradient_x, theta);
    }
}