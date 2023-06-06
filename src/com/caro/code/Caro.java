package com.caro.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Caro extends JFrame {
    private static final int WIDTH = 1300;
    private static final int HEIGHT = 700;
    private static final String sourceImage = "/com/caro/image/";
    private JLayeredPane layeredPaneStart;
    private JLabel labelTitle_Start;
    private JButton buttonContinue_Start;
    private JButton buttonNewGame_Start;
    private JButton buttonQuit_Start;
    private JLabel labelCopyRight_Start;
    private JLayeredPane layeredPaneReady;
    private JLabel labelBack_Ready;
    private JLabel labelTitle_Ready;
    private JLayeredPane layeredPanePlayer1_Ready;
    private JLayeredPane layeredPanePlayer2_Ready;
    private JLabel labelPlayer1_Ready;
    private JLabel labelPlayer2_Ready;
    private JLabel labelTitlePlayer1_Ready;
    private JLabel labelTitlePlayer2_Ready;
    private JLabel labelVS_ChoosePlayer;
    private JButton buttonStart_Ready;
    private JLabel labelCopyRight_Ready;
    private JLayeredPane layeredPanePlay;
    private JLayeredPane layeredPanePlayer1_Play;
    private JLayeredPane layeredPanePlayer2_Play;
    private JLabel labelPlayer1_Play;
    private JLabel labelPlayer2_Play;
    private JLabel labelTitlePlayer1_Play;
    private JLabel labelTitlePlayer2_Play;
    private JLabel labelTimePlayer1_Play;
    private JLabel labelTimePlayer2_Play;
    private JLayeredPane layeredPaneTiso_Play;
    private JLabel labelTiso_Play;
    private JLayeredPane layeredPaneHuongDan_Play;
    private JLabel labelKeysESC_Play;
    private JLabel labelKeysBackspace_Play;
    private JLayeredPane layeredPanePlay_Play;
    private JButton buttonReplay_Play;
    private JButton buttonMain_Play;
    private JButton buttonQuit_Play;
    private JLayeredPane[][] layeredPaneOVuong;
    private JLabel[][] labelXorO;
    private Map<ToaDo, Integer> mapOVuong;
    private List<ToaDo> arrayListOVuongDaDanh;
    private JLayeredPane layeredPaneWin_Play;
    private JLabel labelTitleWin_Play;
    private JLabel labelPlayerWin_Play;
    private boolean start = false;
    private boolean remuse = true;
    private boolean win = false;
    private boolean even = false;
    private int player = 1;
    private int turnPlayer = player;
    private int player1Win = 0;
    private int player2Win = 0;

    public Caro() {
        super("Caro [letienndat]");
        setSize(new Dimension(WIDTH - 4, HEIGHT + 5));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Caro.class.getResource(sourceImage + "icon_caro_title_64x64.png")).getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setFocusable(true);
        requestFocusInWindow();
        init();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (start && !win && !even && e.getKeyChar() == KeyEvent.VK_ESCAPE) {
                    layeredPanePlay.setVisible(false);
                    layeredPaneStart.setVisible(true);
                    buttonContinue_Start.setVisible(true);
                    if (start) {
                        buttonNewGame_Start.setBounds(WIDTH / 2 - 260 / 2, 370, 260, 35);
                        buttonQuit_Start.setBounds(WIDTH / 2 - 260 / 2, 420, 260, 35);
                    } else {
                        buttonContinue_Start.setVisible(false);
                        buttonNewGame_Start.setBounds(WIDTH / 2 - 260 / 2, 320, 260, 35);
                        buttonQuit_Start.setBounds(WIDTH / 2 - 260 / 2, 370, 260, 35);
                    }
                    remuse = true;
                } else if (start && !win && !even && e.getKeyChar() == KeyEvent.VK_BACK_SPACE) {
                    if (arrayListOVuongDaDanh.size() > 0) {
                        mapOVuong.put(arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1), 0);
                        layeredPaneOVuong[arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getX()][arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getY()].remove(labelXorO[arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getX()][arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getY()]);
                        layeredPaneOVuong[arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getX()][arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getY()].setBackground(new Color(255, 255, 255));
                        arrayListOVuongDaDanh.remove(arrayListOVuongDaDanh.size() - 1);
                        if (arrayListOVuongDaDanh.size() > 0) {
                            layeredPaneOVuong[arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getX()][arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getY()].setBackground(new Color(128, 195, 229));
                        }
                        player = player == 1 ? 2 : 1;
                    }
                }
            }
        });
        setLayout(null);
        setVisible(true);
    }

    public void init() {
        initStart();
        initReady();
        initPlay();
    }

    public void initStart() {
        layeredPaneStart = new JLayeredPane();
        layeredPaneStart.setOpaque(true);
        layeredPaneStart.setBackground(new Color(255, 255, 255));
        layeredPaneStart.setBounds(0, 0, WIDTH, HEIGHT);

        labelTitle_Start = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "icon_caro_100x100.png")), JLabel.CENTER);
        labelTitle_Start.setBounds(WIDTH / 2 - 100 / 2, 160, 100, 100);
        labelTitle_Start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        layeredPaneStart.add(labelTitle_Start, 0);

        buttonContinue_Start = new JButton("CONTINUE");
        buttonContinue_Start.setBackground(new Color(0, 142, 255));
        buttonContinue_Start.setBounds(WIDTH / 2 - 260 / 2, 320, 260, 35);
        buttonContinue_Start.setForeground(new Color(255, 255, 255));
        buttonContinue_Start.setFont(new Font("Inter", Font.BOLD, 20));
        buttonContinue_Start.setFocusPainted(false);
        buttonContinue_Start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonContinue_Start.setVisible(false);
        buttonContinue_Start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                layeredPaneStart.setVisible(false);
                layeredPanePlay.setVisible(true);
                remuse = false;
                start = true;
            }
        });
        layeredPaneStart.add(buttonContinue_Start, 0);

        buttonNewGame_Start = new JButton("NEW GAME");
        buttonNewGame_Start.setBackground(new Color(0, 142, 255));
        buttonNewGame_Start.setBounds(WIDTH / 2 - 260 / 2, 320, 260, 35);
        buttonNewGame_Start.setForeground(new Color(255, 255, 255));
        buttonNewGame_Start.setFont(new Font("Inter", Font.BOLD, 20));
        buttonNewGame_Start.setFocusPainted(false);
        buttonNewGame_Start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonNewGame_Start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == buttonNewGame_Start) {
                    layeredPaneStart.setVisible(false);
                    layeredPaneReady.setVisible(true);
                    layeredPaneWin_Play.setVisible(false);
                    start = false;
                    win = false;
                    even = false;
                }
            }
        });
        layeredPaneStart.add(buttonNewGame_Start, 0);

        buttonQuit_Start = new JButton("QUIT");
        buttonQuit_Start.setBackground(new Color(0, 142, 255));
        buttonQuit_Start.setBounds(WIDTH / 2 - 260 / 2, 370, 260, 35);
        buttonQuit_Start.setForeground(new Color(255, 255, 255));
        buttonQuit_Start.setFont(new Font("Inter", Font.BOLD, 20));
        buttonQuit_Start.setFocusPainted(false);
        buttonQuit_Start.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonQuit_Start.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        layeredPaneStart.add(buttonQuit_Start, 0);

        labelCopyRight_Start = new JLabel("Copyright of letienndat");
        labelCopyRight_Start.setBounds(WIDTH / 2 - 120 / 2, HEIGHT - 100, 120, 12);
        labelCopyRight_Start.setFont(new Font("Inter", Font.PLAIN, 10));
        labelCopyRight_Start.setForeground(new Color(0, 0, 0));
        layeredPaneStart.add(labelCopyRight_Start, 0);

        add(layeredPaneStart, 0);
    }

    public void initReady() {
        layeredPaneReady = new JLayeredPane();
        layeredPaneReady.setBackground(new Color(255, 255, 255));
        layeredPaneReady.setBounds(0, 0, WIDTH, HEIGHT);
        layeredPaneReady.setOpaque(true);
        layeredPaneReady.setVisible(false);

        labelBack_Ready = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "back_black_24x24.png")), JLabel.CENTER);
        labelBack_Ready.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        labelBack_Ready.setBounds(20, 10, 24, 24);
        labelBack_Ready.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                layeredPaneReady.setVisible(false);
                layeredPaneStart.setVisible(true);
                remuse = true;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                labelBack_Ready.setIcon(new ImageIcon(Caro.class.getResource(sourceImage + "back_orange_24x24.png")));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelBack_Ready.setIcon(new ImageIcon(Caro.class.getResource(sourceImage + "back_black_24x24.png")));
            }
        });
        layeredPaneReady.add(labelBack_Ready, 0);

        labelTitle_Ready = new JLabel("READY...", JLabel.CENTER);
        labelTitle_Ready.setForeground(new Color(215, 86, 56));
        labelTitle_Ready.setBounds(WIDTH / 2 - 200 / 2, 40, 200, 20);
        labelTitle_Ready.setFont(new Font("Inter", Font.BOLD, 20));
        layeredPaneReady.add(labelTitle_Ready, 0);

        layeredPanePlayer1_Ready = new JLayeredPane();
        layeredPanePlayer1_Ready.setOpaque(true);
        layeredPanePlayer1_Ready.setBounds(WIDTH / 2 - 250 - 100, HEIGHT / 2 - 250, 250, 350);
        layeredPanePlayer1_Ready.setBackground(new Color(120, 223, 236));
        layeredPanePlayer1_Ready.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        labelPlayer1_Ready = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "player1_100x100.png")), JLabel.CENTER);
        labelPlayer1_Ready.setBounds(layeredPanePlayer1_Ready.getWidth() / 2 - 100 / 2, 60, 100, 100);
        layeredPanePlayer1_Ready.add(labelPlayer1_Ready, 0);

        labelTitlePlayer1_Ready = new JLabel("SUPER HERO [Player 1]", JLabel.CENTER);
        labelTitlePlayer1_Ready.setBounds(layeredPanePlayer1_Ready.getWidth() / 2 - 150 / 2, 170, 150, 20);
        labelTitlePlayer1_Ready.setFont(new Font("Inter", Font.BOLD, 13));
        labelTitlePlayer1_Ready.setForeground(new Color(87, 87, 87));
        layeredPanePlayer1_Ready.add(labelTitlePlayer1_Ready, 0);

        layeredPaneReady.add(layeredPanePlayer1_Ready, 0);

        layeredPanePlayer2_Ready = new JLayeredPane();
        layeredPanePlayer2_Ready.setOpaque(true);
        layeredPanePlayer2_Ready.setBounds(WIDTH / 2 + 100, HEIGHT / 2 - 250, 250, 350);
        layeredPanePlayer2_Ready.setBackground(new Color(236, 171, 204));
        layeredPanePlayer2_Ready.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        labelPlayer2_Ready = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "player2_100x100.png")), JLabel.CENTER);
        labelPlayer2_Ready.setBounds(layeredPanePlayer2_Ready.getWidth() / 2 - 100 / 2, 60, 100, 100);
        layeredPanePlayer2_Ready.add(labelPlayer2_Ready, 0);

        labelTitlePlayer2_Ready = new JLabel("SUPER VILLAIN [Player 2]", JLabel.CENTER);
        labelTitlePlayer2_Ready.setBounds(layeredPanePlayer2_Ready.getWidth() / 2 - 170 / 2, 170, 170, 20);
        labelTitlePlayer2_Ready.setFont(new Font("Inter", Font.BOLD, 13));
        labelTitlePlayer2_Ready.setForeground(new Color(87, 87, 87));
        layeredPanePlayer2_Ready.add(labelTitlePlayer2_Ready, 0);

        layeredPaneReady.add(layeredPanePlayer2_Ready, 0);

        labelVS_ChoosePlayer = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "vs_80x80.png")), JLabel.CENTER);
        labelVS_ChoosePlayer.setBounds(WIDTH / 2 - 80 / 2, HEIGHT / 2 - 150, 80, 80);
        layeredPaneReady.add(labelVS_ChoosePlayer, 0);

        buttonStart_Ready = new JButton("START");
        buttonStart_Ready.setForeground(new Color(255, 255, 255));
        buttonStart_Ready.setFont(new Font("Inter", Font.BOLD, 20));
        buttonStart_Ready.setBackground(new Color(0, 142, 255));
        buttonStart_Ready.setFocusPainted(false);
        buttonStart_Ready.setBounds(WIDTH / 2 - 200 / 2, HEIGHT - 190, 200, 35);
        buttonStart_Ready.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonStart_Ready.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                layeredPaneReady.setVisible(false);
                layeredPanePlay.setVisible(true);
                remuse = false;
                start = true;
                clearBanCo();
                player = 1;
                turnPlayer = player;
                player1Win = 0;
                player2Win = 0;
                labelTiso_Play.setText(player1Win + " - " + player2Win);
                Main.timePlayer1.setTime(01, 00);
                Main.timePlayer2.setTime(01, 00);
            }
        });
        layeredPaneReady.add(buttonStart_Ready, 0);

        labelCopyRight_Ready = new JLabel("Copyright of letienndat");
        labelCopyRight_Ready.setFont(new Font("Inter", Font.PLAIN, 10));
        labelCopyRight_Ready.setBounds(WIDTH / 2 - 120 / 2, HEIGHT - 100, 120, 12);
        layeredPaneReady.add(labelCopyRight_Ready, 0);

        add(layeredPaneReady, 0);
    }

    public void initPlay() {
        layeredPanePlay = new JLayeredPane();
        layeredPanePlay.setBounds(0, 0, WIDTH, HEIGHT);
        layeredPanePlay.setOpaque(true);
        layeredPanePlay.setVisible(false);

        layeredPanePlayer1_Play = new JLayeredPane();
        layeredPanePlayer1_Play.setBounds(0, 0, 200, HEIGHT / 2 - 40);
        layeredPanePlayer1_Play.setOpaque(true);
        layeredPanePlayer1_Play.setBackground(new Color(120, 223, 236));

        labelPlayer1_Play = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "player1_100x100.png")), JLabel.CENTER);
        labelPlayer1_Play.setBounds(layeredPanePlayer1_Play.getWidth() / 2 - 100 / 2, 60, 100, 100);
        layeredPanePlayer1_Play.add(labelPlayer1_Play, 0);

        labelTitlePlayer1_Play = new JLabel("SUPER HERO [Player 1]", new ImageIcon(Caro.class.getResource(sourceImage + "x_22x22.png")), JLabel.CENTER);
        labelTitlePlayer1_Play.setBounds(layeredPanePlayer1_Play.getWidth() / 2 - 200 / 2, 170, 200, 20);
        labelTitlePlayer1_Play.setFont(new Font("Inter", Font.BOLD, 13));
        labelTitlePlayer1_Play.setForeground(new Color(87, 87, 87));
        layeredPanePlayer1_Play.add(labelTitlePlayer1_Play, 0);

        labelTimePlayer1_Play = new JLabel("01:00", new ImageIcon(Caro.class.getResource(sourceImage + "time_35x35.png")), JLabel.CENTER);
        labelTimePlayer1_Play.setBounds(layeredPanePlayer1_Play.getWidth() / 2 - 100 / 2, 210, 100, 35);
        labelTimePlayer1_Play.setForeground(new Color(87, 87, 87));
        labelTimePlayer1_Play.setFont(new Font("Inter", Font.BOLD, 15));
        layeredPanePlayer1_Play.add(labelTimePlayer1_Play, 0);

        layeredPanePlay.add(layeredPanePlayer1_Play, 0);

        layeredPanePlayer2_Play = new JLayeredPane();
        layeredPanePlayer2_Play.setBounds(0, HEIGHT / 2 - 40, 200, HEIGHT / 2 - 40);
        layeredPanePlayer2_Play.setOpaque(true);
        layeredPanePlayer2_Play.setBackground(new Color(236, 171, 204));

        labelPlayer2_Play = new JLabel("", new ImageIcon(Caro.class.getResource(sourceImage + "player2_100x100.png")), JLabel.CENTER);
        labelPlayer2_Play.setBounds(layeredPanePlayer2_Play.getWidth() / 2 - 100 / 2, 60, 100, 100);
        layeredPanePlayer2_Play.add(labelPlayer2_Play, 0);

        labelTitlePlayer2_Play = new JLabel("SUPER VILLAIN [Player 2]", new ImageIcon(Caro.class.getResource(sourceImage + "o_22x22.png")), JLabel.CENTER);
        labelTitlePlayer2_Play.setBounds(layeredPanePlayer2_Play.getWidth() / 2 - 200 / 2, 170, 200, 20);
        labelTitlePlayer2_Play.setFont(new Font("Inter", Font.BOLD, 13));
        labelTitlePlayer2_Play.setForeground(new Color(87, 87, 87));
        layeredPanePlayer2_Play.add(labelTitlePlayer2_Play, 0);

        labelTimePlayer2_Play = new JLabel("01:00", new ImageIcon(Caro.class.getResource(sourceImage + "time_35x35.png")), JLabel.CENTER);
        labelTimePlayer2_Play.setBounds(layeredPanePlayer2_Play.getWidth() / 2 - 100 / 2, 210, 100, 35);
        labelTimePlayer2_Play.setForeground(new Color(87, 87, 87));
        labelTimePlayer2_Play.setFont(new Font("Inter", Font.BOLD, 15));
        layeredPanePlayer2_Play.add(labelTimePlayer2_Play, 0);

        layeredPanePlay.add(layeredPanePlayer2_Play, 0);

        layeredPaneTiso_Play = new JLayeredPane();
        layeredPaneTiso_Play.setOpaque(true);
        layeredPaneTiso_Play.setBackground(new Color(255, 255, 255));
        layeredPaneTiso_Play.setBounds(layeredPanePlayer1_Play.getWidth() / 2 - 80 / 2, layeredPanePlayer1_Play.getHeight() - 40 / 2, 80, 40);

        labelTiso_Play = new JLabel(player1Win + " - " + player2Win, JLabel.CENTER);
        labelTiso_Play.setFont(new Font("Inter", Font.BOLD, 25));
        labelTiso_Play.setBounds(0, 8, layeredPaneTiso_Play.getWidth(), 25);
        labelTiso_Play.setForeground(new Color(134, 133, 133));
        layeredPaneTiso_Play.add(labelTiso_Play, 0);

        layeredPanePlay.add(layeredPaneTiso_Play, 0);

        layeredPaneHuongDan_Play = new JLayeredPane();
        layeredPaneHuongDan_Play.setBackground(new Color(195, 164, 255));
        layeredPaneHuongDan_Play.setOpaque(true);
        layeredPaneHuongDan_Play.setBounds(0, layeredPanePlayer2_Play.getY() + layeredPanePlayer2_Play.getHeight(), 200, 50);

        labelKeysESC_Play = new JLabel("MENU", new ImageIcon(Caro.class.getResource(sourceImage + "esc_25x25.png")), JLabel.CENTER);
        labelKeysESC_Play.setFont(new Font("Inter", Font.BOLD, 10));
        labelKeysESC_Play.setForeground(new Color(0, 0, 0));
        labelKeysESC_Play.setBounds(20, 12, 60, 25);
        layeredPaneHuongDan_Play.add(labelKeysESC_Play, 0);

        labelKeysBackspace_Play = new JLabel("UNDO", new ImageIcon(Caro.class.getResource(sourceImage + "backspace_30x30.png")), JLabel.CENTER);
        labelKeysBackspace_Play.setForeground(new Color(0, 0, 0));
        labelKeysBackspace_Play.setFont(new Font("Inter", Font.BOLD, 10));
        labelKeysBackspace_Play.setBounds(110, 9, 70, 30);
        layeredPaneHuongDan_Play.add(labelKeysBackspace_Play, 0);

        layeredPanePlay.add(layeredPaneHuongDan_Play, 0);

        layeredPanePlay_Play = new JLayeredPane();
        layeredPanePlay_Play.setOpaque(true);
        layeredPanePlay_Play.setBounds(200, 0, WIDTH - 200, HEIGHT);
        layeredPanePlay_Play.setBackground(new Color(134, 133, 133));

        layeredPaneOVuong = new JLayeredPane[HEIGHT / 23 - 1][layeredPanePlay_Play.getWidth() / 23];
        mapOVuong = new HashMap<>();
        arrayListOVuongDaDanh = new ArrayList<>();

        labelXorO = new JLabel[HEIGHT / 23 - 1][layeredPanePlay_Play.getWidth() / 23];

        int width = 0;
        int heght = 0;
        int step = 1;

        for (int i = 0; i < layeredPaneOVuong.length; i++) {
            for (int i1 = 0; i1 < layeredPaneOVuong[i].length; i1++) {
                labelXorO[i][i1] = new JLabel("", JLabel.CENTER);
                labelXorO[i][i1].setBounds(0, 0, 22, 22);
                ToaDo toaDo = new ToaDo(i, i1);
                mapOVuong.put(toaDo, 0);

                layeredPaneOVuong[i][i1] = new JLayeredPane();
                layeredPaneOVuong[i][i1].setOpaque(true);
                layeredPaneOVuong[i][i1].setBackground(new Color(255, 255, 255));
                layeredPaneOVuong[i][i1].setBounds(width, heght, 22, 22);
                layeredPaneOVuong[i][i1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                int finalI = i;
                int finalI1 = i1;
                layeredPaneOVuong[i][i1].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (!isWin() && !isEven()) {
                            if (mapOVuong.get(toaDo) == 0) {
                                layeredPaneOVuong[toaDo.getX()][toaDo.getY()].setBackground(new Color(128, 195, 229));
                                if (arrayListOVuongDaDanh.size() >= 1) {
                                    layeredPaneOVuong[arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getX()][arrayListOVuongDaDanh.get(arrayListOVuongDaDanh.size() - 1).getY()].setBackground(new Color(255, 255, 255));
                                }
                                arrayListOVuongDaDanh.add(toaDo);
                                if (player == 1) {
                                    labelXorO[finalI][finalI1].setIcon(new ImageIcon(Caro.class.getResource(sourceImage + "x_22x22.png")));
                                    layeredPaneOVuong[finalI][finalI1].add(labelXorO[finalI][finalI1], 0);
                                    mapOVuong.put(toaDo, 1);
                                    if (getWin(toaDo, player) || getEven()) {
                                        labelTimePlayer1_Play.setText("01:00");
                                        layeredPaneWin_Play.setVisible(true);
                                        remuse = true;
                                        if (getWin(toaDo, player)) {
                                            labelTitleWin_Play.setText("WIN");
                                            labelPlayerWin_Play.setText(labelTitlePlayer1_Play.getText());
                                            labelTiso_Play.setText(++player1Win + " - " + player2Win);
                                        } else if (getEven()) {
                                            labelTitleWin_Play.setText("EVEN");
                                            labelPlayerWin_Play.setText("");
                                        }
                                        if (turnPlayer == 1) {
                                            player = 2;
                                            turnPlayer = 2;
                                        } else {
                                            player = 1;
                                            turnPlayer = 1;
                                        }
                                        return;
                                    }
                                    player = 2;
                                } else if (player == 2) {
                                    labelXorO[finalI][finalI1].setIcon(new ImageIcon(Caro.class.getResource(sourceImage + "o_22x22.png")));
                                    layeredPaneOVuong[finalI][finalI1].add(labelXorO[finalI][finalI1], 0);
                                    mapOVuong.put(toaDo, 2);
                                    if (getWin(toaDo, player) || getEven()) {
                                        labelTimePlayer2_Play.setText("01:00");
                                        layeredPaneWin_Play.setVisible(true);
                                        remuse = true;
                                        if (getWin(toaDo, player)) {
                                            labelTitleWin_Play.setText("WIN");
                                            labelPlayerWin_Play.setText(labelTitlePlayer2_Play.getText());
                                            labelTiso_Play.setText(player1Win + " - " + ++player2Win);
                                        } else if (getEven()) {
                                            labelTitleWin_Play.setText("EVEN");
                                            labelPlayerWin_Play.setText("");
                                        }
                                        if (turnPlayer == 1) {
                                            player = 2;
                                            turnPlayer = 2;
                                        } else {
                                            player = 1;
                                            turnPlayer = 1;
                                        }
                                        return;
                                    }
                                    player = 1;
                                }
                            }
                        }
                    }
                });
                layeredPanePlay_Play.add(layeredPaneOVuong[i][i1], 0);
                width += (22 + step);
            }
            width = 0;
            heght += (22 + step);
        }

        layeredPanePlay.add(layeredPanePlay_Play, 0);

        layeredPaneWin_Play = new JLayeredPane();
        layeredPaneWin_Play.setBounds(layeredPanePlay_Play.getX(), layeredPanePlay_Play.getY(), layeredPanePlay_Play.getWidth(), layeredPanePlay_Play.getHeight());
        layeredPaneWin_Play.setOpaque(true);
        layeredPaneWin_Play.setBackground(new Color(165, 60, 224, 100));
        layeredPaneWin_Play.setVisible(false);

        labelTitleWin_Play = new JLabel("WIN", JLabel.CENTER);
        labelTitleWin_Play.setFont(new Font("Inter", Font.BOLD, 70));
        labelTitleWin_Play.setForeground(new Color(255, 255, 255));
        labelTitleWin_Play.setBounds(layeredPaneWin_Play.getWidth() / 2 - 200 / 2, 100, 200, 70);
        layeredPaneWin_Play.add(labelTitleWin_Play, 0);

        labelPlayerWin_Play = new JLabel("", JLabel.CENTER);
        labelPlayerWin_Play.setFont(new Font("Inter", Font.BOLD, 25));
        labelPlayerWin_Play.setForeground(new Color(255, 255, 255));
        labelPlayerWin_Play.setBounds(layeredPaneWin_Play.getWidth() / 2 - 330 / 2, 180, 330, 25);
        layeredPaneWin_Play.add(labelPlayerWin_Play, 0);

        buttonReplay_Play = new JButton("REPLAY");
        buttonReplay_Play.setBackground(new Color(0, 142, 255));
        buttonReplay_Play.setBounds(layeredPaneWin_Play.getWidth() / 2 - 260 / 2, 320, 260, 35);
        buttonReplay_Play.setForeground(new Color(255, 255, 255));
        buttonReplay_Play.setFont(new Font("Inter", Font.BOLD, 20));
        buttonReplay_Play.setFocusPainted(false);
        buttonReplay_Play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonReplay_Play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearBanCo();
                layeredPaneWin_Play.setVisible(false);
                remuse = false;
                win = false;
                even = false;
            }
        });
        layeredPaneWin_Play.add(buttonReplay_Play, 0);

        buttonMain_Play = new JButton("MAIN");
        buttonMain_Play.setBackground(new Color(0, 142, 255));
        buttonMain_Play.setBounds(layeredPaneWin_Play.getWidth() / 2 - 260 / 2, 370, 260, 35);
        buttonMain_Play.setForeground(new Color(255, 255, 255));
        buttonMain_Play.setFont(new Font("Inter", Font.BOLD, 20));
        buttonMain_Play.setFocusPainted(false);
        buttonMain_Play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonMain_Play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clearBanCo();
                player1Win = 0;
                player2Win = 0;
                labelTiso_Play.setText(player1Win + " - " + player2Win);
                buttonContinue_Start.setVisible(false);
                buttonNewGame_Start.setBounds(WIDTH / 2 - 260 / 2, 320, 260, 35);
                buttonQuit_Start.setBounds(WIDTH / 2 - 260 / 2, 370, 260, 35);
                layeredPaneStart.setVisible(true);
                layeredPanePlay.setVisible(false);
                layeredPaneWin_Play.setVisible(false);
                start = false;
                remuse = true;
                win = false;
                even = false;
            }
        });
        layeredPaneWin_Play.add(buttonMain_Play, 0);

        buttonQuit_Play = new JButton("QUIT");
        buttonQuit_Play.setBackground(new Color(0, 142, 255));
        buttonQuit_Play.setBounds(layeredPaneWin_Play.getWidth() / 2 - 260 / 2, 420, 260, 35);
        buttonQuit_Play.setForeground(new Color(255, 255, 255));
        buttonQuit_Play.setFont(new Font("Inter", Font.BOLD, 20));
        buttonQuit_Play.setFocusPainted(false);
        buttonQuit_Play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buttonQuit_Play.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        layeredPaneWin_Play.add(buttonQuit_Play, 0);

        layeredPanePlay.add(layeredPaneWin_Play, 0);

        add(layeredPanePlay, 0);
    }

    public boolean isStart() {
        return start;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public boolean isRemuse() {
        return remuse;
    }

    public void writeLabelTime(String text, int player) {
        if (player == 1) {
            labelTimePlayer1_Play.setText(text);
        } else if (player == 2) {
            labelTimePlayer2_Play.setText(text);
        }
    }

    public ArrayList<ToaDo> checkWin1(ToaDo toaDo, int player) {
        ArrayList<ToaDo> arrayList = new ArrayList<>();
        arrayList.add(toaDo);
        for (int i = -4; i < 5; i++) {
            if (i == 0) continue;
            ToaDo temp = new ToaDo(toaDo.getX(), toaDo.getY() + i);
            if (mapOVuong.containsKey(temp)) {
                if (mapOVuong.get(temp) == player) {
                    arrayList.add(temp);
                }
            } else {
                if (arrayList.size() >= 5) {
                    arrayList.forEach(e -> {
                        layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
                    });
                    return arrayList;
                }
                arrayList.clear();
            }
        }
        if (arrayList.size() >= 5) {
            arrayList.forEach(e -> {
                layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
            });
            return arrayList;
        }
        return null;
    }

    public ArrayList<ToaDo> checkWin2(ToaDo toaDo, int player) {
        ArrayList<ToaDo> arrayList = new ArrayList<>();
        arrayList.add(toaDo);
        for (int i = -4; i < 5; i++) {
            if (i == 0) continue;
            ToaDo temp = new ToaDo(toaDo.getX() + i, toaDo.getY() - i);
            if (mapOVuong.containsKey(temp)) {
                if (mapOVuong.get(temp) == player) {
                    arrayList.add(temp);
                }
            } else {
                if (arrayList.size() >= 5) {
                    arrayList.forEach(e -> {
                        layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
                    });
                    return arrayList;
                }
                arrayList.clear();
            }
        }
        if (arrayList.size() >= 5) {
            arrayList.forEach(e -> {
                layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
            });
            return arrayList;
        }
        return null;
    }

    public ArrayList<ToaDo> checkWin3(ToaDo toaDo, int player) {
        ArrayList<ToaDo> arrayList = new ArrayList<>();
        arrayList.add(toaDo);
        for (int i = -4; i < 5; i++) {
            if (i == 0) continue;
            ToaDo temp = new ToaDo(toaDo.getX() + i, toaDo.getY());
            if (mapOVuong.containsKey(temp)) {
                if (mapOVuong.get(temp) == player) {
                    arrayList.add(temp);
                }
            } else {
                if (arrayList.size() >= 5) {
                    arrayList.forEach(e -> {
                        layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
                    });
                    return arrayList;
                }
                arrayList.clear();
            }
        }
        if (arrayList.size() >= 5) {
            arrayList.forEach(e -> {
                layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
            });
            return arrayList;
        }
        return null;
    }

    public ArrayList<ToaDo> checkWin4(ToaDo toaDo, int player) {
        ArrayList<ToaDo> arrayList = new ArrayList<>();
        arrayList.add(toaDo);
        for (int i = -4; i < 5; i++) {
            if (i == 0) continue;
            ToaDo temp = new ToaDo(toaDo.getX() + i, toaDo.getY() + i);
            if (mapOVuong.containsKey(temp)) {
                if (mapOVuong.get(temp) == player) {
                    arrayList.add(temp);
                }
            } else {
                if (arrayList.size() >= 5) {
                    arrayList.forEach(e -> {
                        layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
                    });
                    return arrayList;
                }
                arrayList.clear();
            }
        }
        if (arrayList.size() >= 5) {
            arrayList.forEach(e -> {
                layeredPaneOVuong[e.getX()][e.getY()].setBackground(new Color(222, 157, 157));
            });
            return arrayList;
        }
        return null;
    }

    public boolean getWin(ToaDo toaDo, int player) {
        if (checkWin1(toaDo, player) != null || checkWin2(toaDo, player) != null || checkWin3(toaDo, player) != null || checkWin4(toaDo, player) != null) {
            win = true;
            return win;
        }
        return win;
    }

    public boolean isWin() {
        return win;
    }

    public void clearBanCo() {
        arrayListOVuongDaDanh.forEach(i -> {
            layeredPaneOVuong[i.getX()][i.getY()].setBackground(new Color(255, 255, 255));
            layeredPaneOVuong[i.getX()][i.getY()].remove(0);
            mapOVuong.put(i, 0);
        });
        arrayListOVuongDaDanh.clear();
    }

    public boolean getEven() {
        if (arrayListOVuongDaDanh.size() == layeredPaneOVuong[0].length * layeredPaneOVuong.length) {
            labelPlayerWin_Play.setText("");
            labelTitleWin_Play.setText("EVEN");
            even = true;
            return true;
        }
        return false;
    }

    public boolean isEven() {
        return even;
    }
}
