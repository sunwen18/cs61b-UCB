public class LinkedListDeque<Item> {

    public static class DLLNode <Item>{
        public Item item;
        public DLLNode next;
        public DLLNode prev;
        public DLLNode(DLLNode m,Item i, DLLNode n) {
            prev=m;
            item = i;
            next = n;
        }
    }

    private DLLNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new DLLNode(sentinel,20, sentinel);
        sentinel.next=sentinel;
        sentinel.prev=sentinel;
        size = 0;

    }
    public void addFirst(Item x){

        if (isEmpty()){
            sentinel.next=new DLLNode(sentinel,x,sentinel.next);
            sentinel.next.next=sentinel;
            sentinel.prev=sentinel.next;

        }
        else{
            sentinel.next=new DLLNode(sentinel,x,sentinel.next);
            sentinel.next.next.prev=sentinel.next;
        }

        size+=1;
    }
    public void addLast(Item x){
        size+=1;
        sentinel.prev=new DLLNode( sentinel.prev ,x,sentinel );
        sentinel.prev.prev.next=sentinel.prev;

    }
    public boolean isEmpty(){
        if (sentinel.next==sentinel)
            return true;
        else
            return false;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        DLLNode d = sentinel ;
        while(d.next!=sentinel){
            System.out.print(d.next.item);
            d=d.next;
        }
    }
    public Item removeFirst(){
        if (this.isEmpty())
                return null;
        else{
            size =size-1;
            Item temp=(Item)sentinel.next.item;
            sentinel.next=sentinel.next.next;
            sentinel.next.next.prev=sentinel;
            return temp;
        }
    }
    public Item removeLast(){
        if (this.isEmpty())
                return null;
        else{
            Item temp=(Item) sentinel.prev.item;
            size =size-1;
            sentinel.prev=sentinel.prev.prev;
            sentinel.prev.next=sentinel;
            return temp;
        }


    }
    public Item get(int index){
        DLLNode d = sentinel;
        for (int i=1;i<=index;i++){
            d=d.next;
        }
        Item temp=(Item)d.item;
        return temp;
    }
    public Item getRecursive(int index){
        if (index==1){
            return (Item)sentinel.next.item;
        }
        else
            return getRecursive(index-1);

    }
}
