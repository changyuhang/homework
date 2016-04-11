#include "opencv2/opencv.hpp"
#include <iostream>

int main() {
	float scale, dis_x, dis_y;
	std::cout << "請輸入放大縮小倍率:";
	std::cin >> scale;
	std::cout << "請輸入位移x y:";
	std::cin >> dis_x >> dis_y;
	IplImage *imginital = cvLoadImage("a.jpg", 1);
	IplImage *imgfinal;
	imgfinal = cvCreateImage(CvSize(imginital->width * scale + dis_x, imginital->height * scale + dis_y), IPL_DEPTH_8U, 3);

	for (int i = 0; i < imgfinal->height-dis_y; i++) {
		for (int j = 0; j < imgfinal->width-dis_x; j++) {
			int imginital_imgData_index = imginital->widthStep * (int)(i / scale) + (int)(j / scale)*3;
			int imgfinal_imgData_index = imgfinal->widthStep * i + j * 3 + (int)((imgfinal->widthStep * dis_y) +(dis_x * 3)); //上面空行+ 每一行的空格
			imgfinal->imageData[imgfinal_imgData_index] = imginital->imageData[imginital_imgData_index];
			imgfinal->imageData[imgfinal_imgData_index + 1] = imginital->imageData[imginital_imgData_index + 1];
			imgfinal->imageData[imgfinal_imgData_index + 2] = imginital->imageData[imginital_imgData_index + 2];
		}
	}
	cvShowImage("inital", imginital);
	cvShowImage("'final", imgfinal);
	cvWaitKey(0);
}