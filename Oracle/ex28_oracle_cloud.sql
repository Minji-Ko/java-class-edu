-- ex28_oracle_clude.sql

/*
    오라클 클라우드 서비스    
    - Oracle Cloud Free Tier
    - VM(Virtual Machine) > 2대까지 > 나중에 웹 수업 > 프로젝트 운영 or 포트폴리오(웹)
    - Oracle Autonomous Database 2개 > 11g > 19c
    
    
    - 무료 서비스 > 1인 사용 적당
    - 프로젝트 > N인 사용 부족..
    
    *146.56.102.52 
    
    가상 서버
    - 운영체제 > Ubuntu 20.04 LTS
    - 접속 계정 > "ubuntu" + ""
    
    pwd 
    -Print working directory
    -현재작업중 폴더의 경로
    ex) /home/ubuntu/ > ubuntu 계정의 홈디렉토리
    
    ls <옵션> <디렉토리>
    - List Directory Contents
    - '-a' : all. 모든 파일과 디렉토리를 다 출력해라(숨김 파일/디렉토리)
    - '-l' : long. 정보를 상세하게...
    ex) ls -a -l
    ex) ls -al
    ex) ls -la
    ex) ls /home
    
    - : 파일
    d : dir
    l : 바로가기 링크
    
    
    clear
    -Clear Screen
    
    방향키(위 아래)
    - 여태 실행했던 명령어의 이력 탐색
    
    man <명령어>
    - User's Manual 
    
    cd
    - change directory
    ex) cd ..
    ex) cd 자식폴더
    ex) cd / 
    ex) cd ~ 혹은 cd : 홈 디렉토리로 이동
    ex) cd - : 이전 디렉토리로 이동
    
    
    Prompt
    > 계정명@서버이름:현재폴더$
    
    홈디렉토리(~)
    > ubuntu@ubuntu:~$
    
    ubuntu@ubuntu:/home$ 
    ubuntu@ubuntu:/$  > root directory
    
    *단어가 기억이 안날 때? TAP
    
    
    커널 .. 쉘..
    echo "Hello"
    echo $0 > 쓰고 있는 프로그램 ( -bash)
    
    쉘
    1. bash
    2. zsh
    
    free 
    - 메모리 상태를 확인한다.
    
    
    루트 사용자 > root > 모든 권한을 가진 관리자
    현재 로그인 계정 > ubuntu > 일반사용자  > sudo명령어
    
    현재 시각 설정하기 
    - date > 현재 서버시간
    1. $ sudo dpkg-reconfigure tzdata
    2. Asia
    3. Seoul
    4. $ date
    
    
    Swap
    - 메모리의 부족을 보완하기 위해서 > 하드 디스크의 일부 메모리처럼 사용하게 해준다.

    1. $ sudo fallocate -l 4G /swapfile
    2. $ sudo chmod 600 /swapfile
    3. $ sudo mkswap /swapfile
    4. $ sudo swapon /swapfile
    5. $ free
    6. 위의 설정을 서버 재시작시에도 유지
        - /etc/fstab 파일
        

    
    
    파일 열기 > 보기 or 편집
    1. cat <파일>
        - 파일의 내용을 보여준다.
        - 읽기
        - $ cat /etc/fstab
    2. vi, vim, nano
        
    
    shift insert > 복붙
    
    sudo vim /etc/fstab
    swapfile swap swap defaults 0 0
    > esc > : > wq
*/


/*
    웹서버 설치하기
    
    웹서버의 종류
    - 아파치 HTTP 서버
    - NGINX > 현시점 가장 점유율이 높음
    - IIS : 마이크로소프트 인터넷 정보 서비스 > 요즘 점유율이 매우 떨어짐 > 윈도우에만 설치 가능
    - WebtoB, Zeus : 티맥스 소프트에서 개발한 웹 서버 > 국내에서 밀어줌


    리눅스에서 패키지(프로그램) 설치하기
    - apt
    - apt-get
    
    1. $ sudo apt-get update 
        > 현재 시스템의 패키지 상태를 최신버전으로 업데이트
        > 내컴퓨터의 다른 프로그램과 연동하려면 내 프로그램을 최신으로 해둬야함 >  버전을 맞춰줌
    2. $ sudo apt-get install nginx
        > 서버에 알아서 설치파일을 검색 후 다운받아서 실행까지 함
    3. $ sudo systemctl status nginx 
        > 현재 패키지의 상태를 보여준다. > active(running)
    4. $ sudo systemctl stop nginx 
        > 실행중인 패키지를 중단한다.
    5. $ sudo systemctl start nginx
    6. $ sudo systemctl enable nginx // 서버시작시 같이 실행
    (7. $ sudo systemctl disable nginx //자동 시작 중지 )
    
    오라클 클라우드에서 방화벽 열기
    
    우분투에서 방화벽 열기
    - $ sudo iptables -I INPUT 1 -p tcp --dport 80 -j ACCEPT
    - $ sudo iptables -I INPUT 1 -p tcp --dport 443 -j ACCEPT
    
    브라우저 주소창 > IP주소
    
    
    파일 호스트간에 전송 > FTP > 보안이 강화된 SFTP가 이미 설치되어있음
    
    ex)FileZila > FTP클라이언트
    ex)알ftp
    
    Nginx 기본 홈 디렉토리 > /var/www/html
    
    권한부여
    - $ sudo chmod -R 777 /var/www/html
        > 777 : 모든 사람에 대해 모든 권한을 줌

*/



























