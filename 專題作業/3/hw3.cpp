#include "opencv2/opencv.hpp"
#include<iostream>
#define h imginital->height
#define w imginital->width

void main() {
	IplImage *imginital = cvLoadImage("a.jpg", 1);
	IplImage *imgfinal;
	int turn;
	std::cout << "請輸入1(90度),2(180度),3(270度):";
	std::cin >> turn;
	if (turn == 1 || turn == 3) imgfinal = cvCreateImage(CvSize(h, w), IPL_DEPTH_8U, 3);
	else imgfinal = cvCreateImage(CvSize(w, h), IPL_DEPTH_8U, 3);
	for (int i = 0; i < h; i++) {
		for (int j = 0; j < w; j++) {
			int imginital_imgData = imginital->widthStep * (turn != 3 ? (h - i - 1) : i) + (turn == 2 ? (w - j) : j) * 3;
			int imgfinal_imgData = (turn == 2 ? (imgfinal->widthStep * i + j * 3):(imgfinal->widthStep * j + i * 3));
			imgfinal->imageData[imgfinal_imgData] = imginital->imageData[imginital_imgData];
			imgfinal->imageData[imgfinal_imgData + 1] = imginital->imageData[imginital_imgData + 1];
			imgfinal->imageData[imgfinal_imgData + 2] = imginital->imageData[imginital_imgData + 2];
		}
	}
	cvShowImage("Original", imginital);
	cvShowImage("'Result", imgfinal);
	cvWaitKey(0);
}