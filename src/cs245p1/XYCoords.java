/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs245p1;

/**
 *
 * @author Chris
 */
class XYCoords {
    private int x;
    private int y;
    
    public XYCoords(int passedX, int passedY){
        x = passedX;
        y = passedY;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return "[" + x + ", " + y + "]";
    }
}
