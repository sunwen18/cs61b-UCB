public class ArrayDeque<Item> {
    private int size;
    private Item[] items;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (Item[]) new Object [8];
        size=0;
        nextFirst=4;
        nextLast=nextFirst+1+size;

    }
    private int minusOne(int index){
        return (index-1)%items.length;
    }
    private int plusOne(int index){
        return (index+1)%items.length;

    }
    public void addFirst(Item x){
        items[nextFirst]=x;
        size=size+1;
        nextFirst=this.minusOne(nextFirst);
    }
    public void addLast(Item x){
        size=size+1;
        items[nextLast]=x;
        nextLast=this.plusOne(nextLast);

    }
    public boolean isEmpty(){
        if (size==0)
            return true;
        else return false;

    }
    public int size(){
        return size;
    }
    public void printDeque(){
        int i=nextFirst;
        while(this.plusOne(nextFirst)!=nextLast){
            System.out.print(items[nextFirst]);
        }


    }
    public Item removeFirst(){
        size=size-1;
        nextFirst=this.plusOne(nextFirst);
        Item temp=items[nextFirst];
        items[nextFirst]=null;
        return temp;

    }
    public Item removeLast(){
        size=size-1;
        nextLast=this.minusOne(nextLast);
        Item temp=items[nextLast];
        items[nextLast]=null;
        return temp;
    }
    public Item get(int index){
        return items[index];

    }

}
