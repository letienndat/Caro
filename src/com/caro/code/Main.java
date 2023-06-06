package com.caro.code;

public class Main {
    static Time timePlayer1 = new Time(01, 00);
    static Time timePlayer2 = new Time(01, 00);

    public static void main(String[] args) {
        Caro caro = new Caro();
        a:
        while (true) {
            try {
                if (caro.getPlayer() == 1 && caro.isStart() && !caro.isWin() && !caro.isEven()) {
                    caro.writeLabelTime(timePlayer1.toString(), caro.getPlayer());
                } else if (caro.getPlayer() == 2 && caro.isStart() && !caro.isWin() && !caro.isEven()) {
                    caro.writeLabelTime(timePlayer2.toString(), caro.getPlayer());
                }
                for (int i = 0; i < 20; i++) {
                    if (caro.isWin()) {
                        timePlayer1.setTime(01, 00);
                        caro.writeLabelTime(timePlayer1.toString(), 1);
                        timePlayer2.setTime(01, 00);
                        caro.writeLabelTime(timePlayer2.toString(), 2);
                    }
                    if (caro.getPlayer() == 1 && caro.isStart() && !caro.isWin() && !caro.isEven()) {
                        timePlayer2.setTime(1, 0);
                        caro.writeLabelTime(timePlayer2.toString(), 2);
                    } else if (caro.getPlayer() == 2 && caro.isStart() && !caro.isWin() && !caro.isEven()) {
                        timePlayer1.setTime(1, 0);
                        caro.writeLabelTime(timePlayer1.toString(), 1);
                    }
                    Thread.sleep(45);
                }
                if (caro.isStart() && !caro.isRemuse() && !caro.isWin() && !caro.isEven()) {
                    if (timePlayer1.endTime()) {
                        caro.setPlayer(2);
                        timePlayer1.setTime(1, 0);
                        continue;
                    } else if (timePlayer2.endTime()) {
                        caro.setPlayer(1);
                        timePlayer2.setTime(1, 0);
                        continue;
                    }
                    if (caro.getPlayer() == 1) {
                        timePlayer1.previousSecond();
                        timePlayer2.setTime(1, 0);
                        caro.writeLabelTime(timePlayer2.toString(), 2);
                    } else if (caro.getPlayer() == 2) {
                        timePlayer2.previousSecond();
                        timePlayer1.setTime(1, 0);
                        caro.writeLabelTime(timePlayer1.toString(), 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
