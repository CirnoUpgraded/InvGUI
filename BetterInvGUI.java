package top.n0rthmaster123.betterinvgui;

import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class BetterInvGUI {

    public InvGUI(){

    }
    
    /** 
    *
    * @author BaGuAr  
    * 
    * I remake InvGUI.java. old own is here:
    * https://github.com/BaGuAr/InvGUI/blob/main/InvGUI.java
    * also BetterInvGUI.java is not tested. if you found bugs. please report it!
    * If you'll use this , do not remove this message 
    * and If you'll upload your project(that using this) to Internet(spigot-mc/mc-market etc) please put this github(BetterInvGUI.java) link to your project's description
    * Thanks for using this!
    *
    */  
    
    private Inventory inv;
    private int hight;
    private int width;
    
    public InvGUI create(Inventory from){
        inv = from;
        return this;
    }

    public InvGUI create(String name,int hight,int width){
        inv = Bukkit.createInventory( null ,hight * width ,name );
        return this;
    }

    public InvGUI create(String name,int size){
        inv = Bukkit.createInventory( null ,size ,name );
        return this;
    }

    public enum ChestType{
        LARGE,NORMAL
    }

    public InvGUI create(String name,ChestType c){
        return create( name ,( c == ChestType.LARGE ? 6 : 3 ) * 9 );
    }

    public InvGUI setName(String name){
        Inventory inv = new InvGUI().create( name , getSlotLength() + 1 ).getInventory();
        inv.setContents( this.inv.getContents() );
        this.inv = inv;
        return this;
    }

    public InvGUI setHight(int hight){
        this.hight = hight;
        inv.setMaxStackSize( hight * width );
        return this;
    }

    public InvGUI setWidth(int width){
        this.width = width;
        inv.setMaxStackSize( hight * width );
        return this;
    }

    public int getHight(){
        return hight;
    }

    public int getWidth(){
        return width;
    }

    public int[] getSize(){
        return new int[]{getHight(),getWidth()};
    }

    public InvGUI addItem(String name,ItemStack stack,int index){
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
        inv.setItem( index,stack );
        return this;
    }

    public InvGUI addItem(String name,Material material,int index){
        return addItem( name , new ItemStack( material ) , index );
    }

    public InvGUI addItem(String name,ItemStack stack,List list,int index){
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(list);
        stack.setItemMeta(meta);
        inv.setItem( index , stack );
        return this;
    }

    public InvGUI addItem(String name,Material material,List list,int index){
        return addItem( name , new ItemStack( material ) , list, index );
    }
    
    public InvGUI addItem(ItemStack stack,int index){
        inv.setItem( index , stack );
        return this;
    }

    public InvGUI addItem(Material material,int index){
        return addItem( new ItemStack( material ) , index );
    }
    
    public int getSlotLength(){
        return ( hight * width ) - 1;
    }


    public Inventory getInventory(){
        return inv;
    }
    
    @Deprecated
    public List getAsList(String str){
        List list = new ArrayList();
        String[] strx = str.split( "\n" );
        for( String string : strx ){
            list.add( string );
        }
        return list;
    }
}
