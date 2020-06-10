// -----------------------------------------------------
// Assignment: 4
// Part B
// Written by: Le Cherng Lee 40122814
// -----------------------------------------------------
package assignment4;

import java.util.NoSuchElementException;

/**
 *
 * @author Le Cherng
 */
public class CellList implements Cloneable{
    public CellNode head;
    public int size;
    
    public CellList(){
        head=null;
        size=0;
    }
    public CellList(CellList C) throws CloneNotSupportedException {
        //I got another idea that it can works :p
        //CellList hey = new CellList();
        //yeaharrrrr
        size=C.size;
        if(C == null){
            throw new NullPointerException();
        }
        if (C.head == null){
            head = null;
        }else{	// Call our clone() method to copy the list
            head = clone(C.head);
        }
    }
    
    @Override
    public CellList clone(){
        try{
                    CellList newCL = (CellList)super.clone();
                    if (head == null){
                        newCL.head = null;
                    }else{
                        newCL.head = clone(head);
                        newCL.size= this.size;
                    }
                    return newCL;
                }catch (CloneNotSupportedException e){
			return null;
                }
    }
    
    private void changeSize(int S){
        size=S;
    }
    
    
    private CellNode clone(CellNode c) throws CloneNotSupportedException

	{
		CellNode temp = c;
                CellNode newHead = null;
		CellNode end = null;		/**This pointer will always point at the end of the new list 
						* while it is being created (growing)
                                                *cellphone cloning
                                                * first node will be done first on newHead
                                                */
		newHead = new CellNode(temp.cellphone.clone(), null);
		end = newHead;
                //this will point towards the end :D
		temp = temp.next;
		while (temp != null)
		{
			end.next = new CellNode(temp.cellphone.clone(), null);
                        //the list the were gonna be cloned will get next to keep shifting position
			end = end.next;
			temp = temp.next;
		}
		// Now the entire list is created, just return its head pointer
		return newHead;
	}
    
    public void addToStart(CellPhone C){
        CellNode newNode= new CellNode(C, new CellNode());
        if(head==null){
            newNode.next=head;
            head=newNode;
        }else{
            CellNode last = head;
            //pointerrrrr

            head= newNode;
            head.next=last;
            
            
        }
        
        
        size++;
    }
    
    public void insertAtIndex(CellPhone C, int index){
        int num = size-1;
        //so you cannot add at the end? Why??????
        CellNode newNode= new CellNode(C, new CellNode());
        if(index<0 || index>num){
            throw new NoSuchElementException();
        }else{
            
            if(head==null){
                addToStart(C);
            }else{
                CellNode current = this.head;
                if(index==0){
                    addToStart(C);
                }else{
                    for(int i=0; i<index-1;i++){
                        //it will reach to the index position :3
                        current= current.next;
                    }   
                    newNode.next= current.next;
                    current.next=newNode;
                    size++;
                }
                
            }
           
        }
    }
    
    public void deleteFromIndex(int index){
        int num=size-1;
        if(index<0 || index>num){
            throw new NoSuchElementException();
        }else{
            CellNode current = head;
            if(index ==0){
                head= current.next;
            }else{
                for(int i=0; i<index-1;i++){
                    //it will reach to the index position :3
                    current= current.next;
                }
                CellNode next= current.next.next;
                //why it shows unused assignment??? :( 
                current.next = next;
            }  
            size--;
        }
    }
    
    public void deleteFromStart(){
        if(size==0){
            System.out.println("Your list is empty, nothing will be done");
        }else if(size==1){
            head=null;
            size--;
        }else{
            CellNode current= head;
            head=current.next;
            size--;
        }
        
    }
    
    public void replaceAtIndex(CellPhone C, int index){
        int num = size-1;
        //so you cannot add at the end? Why??????
        CellNode newNode= new CellNode(C, new CellNode());
        if(index<0 || index>num){
            throw new NoSuchElementException();
        }else{
            CellNode last = head;
            if(index==0){
                newNode.next=head;
                head=newNode;
            }else{
                for(int i=0; i<index-2;i++){
                    //it will reach to the index position :3
                    last= last.next;
                }
                newNode.next= last.next.next.next;
                last.next=newNode;
                
            }
        }
    }

    
    public CellNode find(long SN){
        int tracking=0;
        CellNode current = head;
        while(current.next!=null){
            if(current.cellphone.getSerialNum()==SN){
                System.out.println("Serial Number is found :D");
                return current;
            }
            current = current.next;
            System.out.println(++tracking);
        }
        
        System.out.println("Serial Number not found :O");
        return null;
    }
    
    public boolean contains(long SN){
        int tracking=0;
        CellNode current = head;
        while(current.next!=null){
            if(current.cellphone.getSerialNum()==SN){
                System.out.println("Serial Number is found :D");
                return true;
            }
            current = current.next;
            System.out.println(++tracking);
        }
        
        System.out.println("Serial Number not found :O");
        return false;
    }
    
    public String showContents(){
        String header= "The current size of the list is "+size+" Here are the contents of the list"
                +"\n=====================================================================================\n";
        String body="";
        int i=0;
        CellNode last = head;
        while(last != null){
            System.out.println(i+last.cellphone.toString());
            body+= "["+last.cellphone.toString() +"] ===>";
            last= last.next;
            i++;
        }
        
        body+=" X";
        return header+body;
    }
    
    public boolean equals(CellList C){
        //two loops
        //one for first celllist another one is for second celllist
        CellNode current1 = this.head;
        
        for(int i=0; i<this.getSize(); i++){
            System.out.println("First List: "+i);
            for(int j=0; j<C.size;j++){
                System.out.println("Second List: "+j);
                CellNode current2= C.head;
                if(current1.cellphone.equal(current2.cellphone)){
                    return true;
                }
                current2= current2.next;
            }
            current1= current1.next;
        }
        //if the if condition is not reached, it will come here
        return false;
    }
    
    public int getSize(){
        return size;
    }
    
    static class CellNode{
        public CellPhone cellphone;
        public CellNode next;
        
        public CellNode(){
            cellphone=null;
            next=null;
        }
        public CellNode(CellPhone object, CellNode node){
            cellphone= object;
            next=node;
        }
        
        
        
        
        public CellNode getNext(){
            return next;
        }
        public void changeNext(CellNode C){
            next= C;
        }
        public void changeCellphone(CellPhone C){
            cellphone= C;
        }
        public CellPhone getCellphone(){
            return this.cellphone;
        }
    }
    
}
