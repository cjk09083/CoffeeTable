# CoffeeTable
 
<img src="https://img.shields.io/badge/Arduino-00979D?style=flat-square&logo=Arduino&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=Android&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Bluetooth-0082FC?style=flat-square&logo=Bluetooth&logoColor=white"/></a>

<div align="center">
<img src="https://user-images.githubusercontent.com/87401241/190396893-1c7db836-3f85-47b7-8b35-2ca292c73953.gif" width="30%">
</div></br>

## 목적
- 기존 테이블에 컵 감지와, 제스처, 음악재생 기능을 추가
- 앱과 블루투스 연동하여 실시간 제어 가능하게

## 담당
- 아두이노 코딩
- 안드로이드 앱 제작

## 구성

<div align="center">
<img src="https://user-images.githubusercontent.com/87401241/190392601-c50d67c5-e14e-4ef8-ba51-c793faf3b898.PNG" width="50%">
</div></br>

- 아두이노 메가 + MP3 쉴드
- 적외선 센서
- LED
- 제스처 센서
- 블루투스 모듈

## 기능

### 1. 컵 인식
- 적외선 센서를 이용하여 각 네모칸에 컵이 올라왔는지 아닌지 인식
- 적외선 발신부와 수신부를 다른각도로 설치하여 테이블 윗면에 장착된 아크릴은 인식못하고 컵만 인식되도록 조절
- 컵이 인식되면 아래와 같이 파도 형태로 빛이 퍼져나감
<img src="https://user-images.githubusercontent.com/87401241/190394288-921b683e-1b97-44fa-966c-8fc42c9e6a21.png" width="100%"> 

- 현재 색상 모드에 따라 다른 색으로 빛남 (4번 모드는 무작위 색상)
<img src="https://user-images.githubusercontent.com/87401241/190394258-da177381-f5d8-4138-bfb3-46120c5355a7.png" width="100%">

### 2. 블루투스 통신
- 아두이노와 안드로이드 앱 간의 블루투스 통신으로 동기화
- 테이블에 컵이 인식되면 앱에서도 해당 위치가 점등
- 앱에서 모드, 음악을 변경시 테이블에 적용 (테이블에서 변경시 앱에도 적용)
<img src="https://user-images.githubusercontent.com/87401241/190394736-4e6ac3a4-6b66-49a0-93d5-ce7a30b0ae50.png" width="100%">

### 3. 제스처 인식
- 테이블 옆면에 제스처 센서를 장착하여 사용자의 제스처를 인식
- 인식되는 명령은 이전모드, 다음모드, 볼륨업, 볼륨다운, 일시정지/재생 총 5가지

## 문제점 및 해결방안
- 모든 센서와 아두이노의 GND가 통일되지 않아 스피커에서 노이즈 발생 
  => 건물 GND에 직접 통일
- 적외센 센서에 아크릴이 인식
  => 적외센 발신부와 수신부 각도를 조절하여 컵만 인식되도록 변경

