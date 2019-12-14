package dku.presentation.group.com.register;

import java.util.ArrayList;
import java.util.List;

public class ImagesOfGrid {

    private int name ;
    private boolean checked ;
    private int tag ;

    public ImagesOfGrid(){

    }

    public  ImagesOfGrid(int name , boolean checked, int tag){
        this.name = name;
        this.checked = checked ;
        this.tag = tag;
    }

    public int getName() {
        return name;
    }

    public int getTag() {
        return tag;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public static List<ImagesOfGrid> getImages(){

        ImagesOfGrid light1 = new ImagesOfGrid(R.drawable.img1,false,0);
        ImagesOfGrid light2 = new ImagesOfGrid(R.drawable.img2,false,1);
        ImagesOfGrid light3 = new ImagesOfGrid(R.drawable.img3,false,2);
        ImagesOfGrid light4 = new ImagesOfGrid(R.drawable.img4,false,3);
        ImagesOfGrid light5 = new ImagesOfGrid(R.drawable.img5,false,4);
        ImagesOfGrid light6 = new ImagesOfGrid(R.drawable.img6,false,5);
        ImagesOfGrid light7 = new ImagesOfGrid(R.drawable.img7,false,6);
        ImagesOfGrid light8 = new ImagesOfGrid(R.drawable.img8,false,7);
        ImagesOfGrid light9 = new ImagesOfGrid(R.drawable.img9,false,8);


        List<ImagesOfGrid> items = new ArrayList<>() ;

        items.add(light1);
        items.add(light2);
        items.add(light3);
        items.add(light4);
        items.add(light5);
        items.add(light6);
        items.add(light7);
        items.add(light8);
        items.add(light9);

        return items;
    }
}


