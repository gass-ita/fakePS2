package Controller;
import java.awt.Color;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.DefaultButtonModel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import Utils.Debugger;

import java.awt.Graphics;

public class LayerManager implements MouseListener, MouseMotionListener{
    /* ----------------------------- EXTERNAL ACCESS ---------------------------- */
    private static ArrayList<Layer> LayerList = new ArrayList<>();
    /* ----------------------------- INTERNAL ACCESS ---------------------------- */
    
    private int x;
    private int y;
    private Layer SelectedLayer;
    public LayerManager(){
        
    }

    public void dragging(int x, int y){
        switch (Info.selectedTool) {
            case Info.Tool.BRUSH:
                Debugger.log(LayerList.get(Info.selectedLayer));
                
                SelectedLayer = LayerList.get(Info.selectedLayer);
                
                break;
        }
    }


    public static BufferedImage createView(int weight, int height) throws IOException{
        /*for(Layer layer : LayerList){
            for(int i = 0; i < layer.w; i++){
                for(int j = 0; j < layer.h; j++){
                    
                    g.setColor(new Color(layer.pixels[i][j]));
                    g.drawLine(i, j, i, j);
                    panel.repaint();
                }
            }
        }*/
        BufferedImage img = new BufferedImage(weight, height, BufferedImage.TYPE_INT_RGB);
        for(Layer layer : LayerList){
            ByteArrayInputStream inputStream = new ByteArrayInputStream(layer.bytes);
            img = ImageIO.read(inputStream);
            
        }

        return img;
    }

    public void addLayer(Layer newLayer){
        LayerManager.LayerList.add(newLayer);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }


    // aggiungere una funziona che aggiunge i layer alla lista
    /*public void addOn(JPanel bg){
        for(Layer l : LayerList){
            Debugger.log("I add this " + l);
            bg.add(l);
        }
    }*/


    
}
