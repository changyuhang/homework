#define _USE_MATH_DEFINES

#include "opencv2/opencv.hpp"
#include<iostream>
#include<cmath>


#define h imginital->height
#define w imginital->width
void main() {
	IplImage *imginital = cvLoadImage("a.jpg", 1);
	IplImage *imgfinal;
	IplImage *imgtemp;
	int max_hw;
	max_hw = (int)(sqrt(imginital->height*imginital->height + imginital->width*imginital->width) + 1);
	float dis_x, dis_y;
	dis_x = (max_hw - w) / 2;
	dis_y = (max_hw - h) / 2;

	int turn;
	std::cout << "�п�J1(90��),2(180��),3(270��):";
	std::cin >> turn;
	imgfinal = cvCreateImage(CvSize(max_hw, max_hw), IPL_DEPTH_8U, 3);

	turn = turn*(M_PI / 180);
	double vcos = cos(turn), vsin = sin(turn);

	for (int i = 0; i < imginital->height; i++) {
		for (int j = 0; j < imginital->width; j++) {
			int nx = (int)(vcos*(j+dis_x) - vsin*(i+dis_y));
			int ny = (int)(vsin*(j+dis_x) + vcos*(i+dis_y));
			int imginital_imgData = imginital->widthStep * i + j * 3;
			int imgfinal_imgData = imgfinal->widthStep *ny + nx * 3;//+ (int)((imgfinal->widthStep * dis_y) + (dis_x * 3)); //�W���Ŧ�+ �C�@�檺�Ů�
			imgfinal->imageData[imgfinal_imgData] = imginital->imageData[imginital_imgData];
			imgfinal->imageData[imgfinal_imgData + 1] = imginital->imageData[imginital_imgData + 1];
			imgfinal->imageData[imgfinal_imgData + 2] = imginital->imageData[imginital_imgData + 2];
		}
	}

	cvShowImage("Original", imginital);
	cvShowImage("'Result", imgfinal);
	cvWaitKey(0);
}

//#define _USE_MATH_DEFINES
//
//#include "opencv2/opencv.hpp"
//#include<iostream>
//#include<cmath>
//
//#define h imginital->height
//#define w imginital->width
//void main() {
//	IplImage *imginital = cvLoadImage("a.jpg", 1);
//	IplImage *imgfinal;
//	int turn;
//	std::cout << "�п�J1(90��),2(180��),3(270��):";
//	std::cin >> turn;
//	if (turn == 1 || turn == 3) imgfinal = cvCreateImage(CvSize(h, w), IPL_DEPTH_8U, 3);
//	else imgfinal = cvCreateImage(CvSize(w, h), IPL_DEPTH_8U, 3);
//	for (int i = 0; i < h; i++) {
//		for (int j = 0; j < w; j++) {
//			//int imginital_imgData = imginital->widthStep * (turn != 3 ? (h - i - 1) : i) + (turn == 2 ? (w - j) : j) * 3;
//			//int imgfinal_imgData = (turn == 2 ? (imgfinal->widthStep * i + j * 3) : (imgfinal->widthStep * j + i * 3));
//			int imginital_imgData = imginital->widthStep * i + j * 3;
//			int imgfinal_imgData = abs(imginital->widthStep * (i*cos(M_PI / 180 * turn) - j*sin(M_PI / 180 * turn)) + (i*sin(M_PI / 180 * turn) + j*cos(M_PI / 180 * turn)) * 3);
//			imgfinal->imageData[imgfinal_imgData] = imginital->imageData[imginital_imgData];
//			imgfinal->imageData[imgfinal_imgData + 1] = imginital->imageData[imginital_imgData + 1];
//			imgfinal->imageData[imgfinal_imgData + 2] = imginital->imageData[imginital_imgData + 2];
//		}
//	}
//	cvShowImage("Original", imginital);
//	cvShowImage("'Result", imgfinal);
//	cvWaitKey(0);
//}