package de.gurkenlabs.utiliti.swing.dialogs;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.graphics.animation.Animation;
import de.gurkenlabs.litiengine.graphics.animation.AnimationController;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationPreview extends JPanel implements IUpdateable {
    private JSpinner spinnerHeight;
    private JSpinner spinnerWidth;
    private transient AnimationController controller;
    private JLabel labelAnimationPreview;

    public AnimationPreview(Animation animation) {
        controller = new AnimationController();

        JPanel panel = new JPanel();
        panel.setBorder(null);
        add(panel, BorderLayout.CENTER);

        labelAnimationPreview = new JLabel("HEjsan");
        labelAnimationPreview.setPreferredSize(new Dimension(200, 200));
        labelAnimationPreview.setMinimumSize(new Dimension(0, 200));
        labelAnimationPreview.setMaximumSize(new Dimension(0, 200));
        labelAnimationPreview.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(labelAnimationPreview);
        this.controller.getAll().clear();
        this.controller.setDefault(animation);
        this.controller.play(animation.getName());
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 300);
        frame.setLocation(375, 55);
        Game.loop().attach(this);
    }


    @Override
    public void update() {
        this.controller.update();
        BufferedImage img = this.controller.getCurrentImage();
        if (img != null) {
            this.labelAnimationPreview.setIcon(new ImageIcon(img));
        } else {
            this.labelAnimationPreview.setIcon(null);
        }
    }
}
