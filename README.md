# CoffeeTable
커피테이블 (Arduino + Android)

## 목적
- 기존 테이블에 컵 감지와, 제스처, 음악재생 기능을 추가
- 앱과 블루투스 연동하여 실시간 제어 가능하게

## 담당
- 아두이노 코딩
- 안드로이드 앱 제작

## 구성
<img src="https://user-images.githubusercontent.com/87401241/190392601-c50d67c5-e14e-4ef8-ba51-c793faf3b898.PNG" width="600">

- 아두이노 메가 + MP3 쉴드
- 적외선 센서
- LED
- 제스처 센서
- 블루투스 모듈

## 기능
### 1. 컵 인식
- 적외선 센서를 이용하여 각 네모칸에 컵이 올라왔는지 아닌지 인식
- 컵이 인식되면 아래와 같이 파도 형태로 빛이 퍼져나감
<img src="https://user-images.githubusercontent.com/87401241/190394288-921b683e-1b97-44fa-966c-8fc42c9e6a21.png" width="600">

- 현재 색상 모드에 따라 다른 색으로 빛남 (4번 모드는 무작위 색상)
<img src="https://user-images.githubusercontent.com/87401241/190394258-da177381-f5d8-4138-bfb3-46120c5355a7.png" width="600">

### 2. 블루투스 통신


### 3. 제스처 인식

## 문제점 및 해결방안
