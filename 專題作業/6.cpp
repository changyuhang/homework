#include <opencv/cv.h>
#include <opencv/highgui.h>
#include <iostream>
#include <cmath>
#include <string>

using namespace std;
void onMouse(int event, int x, int y, int flags, void* param);
IplImage *Image_original, *Image_gray;
CvPoint point;
CvScalar Color = CV_RGB(0, 0, 0);
int key = 0;
CvFont font = cvFont(1, 2);
int main() {
    Image_original = cvLoadImage("/Users/yuhang/Desktop/1.jpg", 1);
    Image_gray = cvLoadImage("/Users/yuhang/Desktop/1.jpg", 0);
    
    cvNamedWindow("mouse_test", 0);
    
    cvSetMouseCallback("mouse_test", onMouse, NULL);
    cvShowImage("mouse_test", Image_original);
    cvWaitKey(0);
}
void onMouse(int event, int x, int y, int flag, void* param) {
    point = cvPoint(x, y);
    if (event == CV_EVENT_LBUTTONDOWN || event == CV_EVENT_RBUTTONDOWN) {
        cvReleaseImage(&Image_original);
        Image_original = cvLoadImage("/Users/yuhang/Desktop/1.jpg", 1);
        printf("(x:%d,y:%d)", x, y);
        printf("(Blue:%d,Green:%d,Red:%d)\n", uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3)]), uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3) + 1]), uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3) + 2]));
        int Neighbor_pixel[8] = {}, gradient_x, gradient_y;
        Neighbor_pixel[0] = Image_gray->imageData[Image_gray->widthStep*(y - 1)+x - 1];
        Neighbor_pixel[1] = Image_gray->imageData[Image_gray->widthStep*(y - 1)+x];
        Neighbor_pixel[2] = Image_gray->imageData[Image_gray->widthStep*(y - 1)+x + 1];
        Neighbor_pixel[3] = Image_gray->imageData[Image_gray->widthStep*y+x - 1];
        Neighbor_pixel[4] = Image_gray->imageData[Image_gray->widthStep*y+x + 1];
        Neighbor_pixel[5] = Image_gray->imageData[Image_gray->widthStep*(y+1)+x - 1];
        Neighbor_pixel[6] = Image_gray->imageData[Image_gray->widthStep*(y+1)+x];
        Neighbor_pixel[7] = Image_gray->imageData[Image_gray->widthStep*(y+1)+x + 1];
        gradient_x = (Neighbor_pixel[2] + Neighbor_pixel[4] * 2 + Neighbor_pixel[7]) - (Neighbor_pixel[0] + Neighbor_pixel[3] * 2 + Neighbor_pixel[5]);
        gradient_y = (Neighbor_pixel[5] + Neighbor_pixel[6] * 2 + Neighbor_pixel[7]) - (Neighbor_pixel[0] + Neighbor_pixel[1] * 2 + Neighbor_pixel[2]);
        printf("gx:%d gy:%d",gradient_x,gradient_y);
        double theta = atan2(gradient_y, gradient_x) * 180 / CV_PI;
        if(theta<0)theta+=360;
        char out1[100]="", buffer[10];
        sprintf(buffer, "(%d,", x);
        strcat(out1, buffer);
        sprintf(buffer, "%d),", y);
        strcat(out1, buffer);
        sprintf(buffer, "(%d,", uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3)]));
        strcat(out1, buffer);
        sprintf(buffer, "%d,", uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3) + 1]));
        strcat(out1, buffer);
        sprintf(buffer, "%d),", uchar(Image_original->imageData[(Image_original->widthStep * (y - 1) + x * 3)+2]));
        strcat(out1, buffer);
        sprintf(buffer, "%.2lf", (theta));
        strcat(out1, buffer);
        
        cvPutText(Image_original, out1, point, &font, Color);
        cvShowImage("mouse_test", Image_original);
        printf("%d %d 角度:%.2lf度\n", gradient_y, gradient_x, theta);
    }
}