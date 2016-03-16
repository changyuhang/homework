#include "opencv2/opencv.hpp"
#include<iostream>
#include<cmath>
#define h imginital->height
#define w imginital->width
#define nh cvRound(fabs(h*vcos)+fabs(w*vsin))
#define nw cvRound(fabs(w*vcos)+fabs(h*vsin))
void main() {
	IplImage *imginital = cvLoadImage("a.jpg", 1);
	IplImage *imgfinal;
	double turn;
	std::cout << "請輸入旋轉幾度:";
	std::cin >> turn;
	turn = turn*(CV_PI / 180);
	double vcos = cos(turn), vsin = sin(turn);
	imgfinal = cvCreateImage(CvSize(nw, nh), IPL_DEPTH_8U, 3);
	double offset_x, offset_y;
	offset_x = -nw / 2.0f * vcos - nh / 2.0f * vsin + w / 2.0f;
	offset_y = nw / 2.0f * vsin - nh / 2.0f * vcos + h / 2.0f;
	std::cout << offset_x << " " << offset_y << std::endl;
	//offset_x = 0;
	//offset_y = 0;
	for (int ny = 0; ny < imgfinal->height; ny++) {
		for (int nx = 0; nx < imgfinal->width; nx++) {
			int x = (int)(nx*vcos + ny*vsin + 0.5) + offset_x;
			int y = (int)(-nx*vsin + ny*vcos + 0.5) + offset_y;
			int imginital_imgData = imginital->widthStep * y + x * 3;
			int imgfinal_imgData = imgfinal->widthStep *ny + nx * 3;
			if (x<0 || y<0 || x >= imginital->width || y >= imginital->height){
				imgfinal->imageData[imgfinal_imgData] = imgfinal->imageData[imgfinal_imgData + 1] = imgfinal->imageData[imgfinal_imgData + 2] = 127;
			}
			else{
				imgfinal->imageData[imgfinal_imgData] = imginital->imageData[imginital_imgData];
				imgfinal->imageData[imgfinal_imgData + 1] = imginital->imageData[imginital_imgData + 1];
				imgfinal->imageData[imgfinal_imgData + 2] = imginital->imageData[imginital_imgData + 2];
			}
		}
	}

	cvShowImage("Original", imginital);
	cvShowImage("'Result", imgfinal);
	cvWaitKey(0);
}