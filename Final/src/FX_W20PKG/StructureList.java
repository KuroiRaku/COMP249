/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FX_W20PKG;

import java.util.NoSuchElementException;

/**
 *
 * @author Le Cherng
 */
public class StructureList {
    public StructureNode head;
    public int size;
    
    public StructureList(){
        head=null;
        size=0;
    }
    public StructureList(StructureList C) throws CloneNotSupportedException {
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
            head =clone(C.head);
        }
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
		try{
                    StructureList newCL = (StructureList)super.clone();
                    if (head == null){
                        newCL.head = null;
                    }else{
                        newCL.head = clone(head);
                        newCL.size= this.size;
                    }
                    return newCL;
                }catch (CloneNotSupportedException e){	//This should not happen
			return null;
                }
    }
    
    private StructureNode clone(StructureNode c) throws CloneNotSupportedException{
		StructureNode temp = c;
                StructureNode newHead = null;
		StructureNode end = null;		// This pointer will always point at the end of the new list 
								// while it is being created (growing)
                                                                //cellphone cloning
                                                                //first node will be done first on newHead
		newHead = new StructureNode(temp.sObj.clone(), null);
		end = newHead;
                //this will point towards the end :D
		temp = temp.next;
		while (temp != null){
			end.next = new StructureNode(temp.sObj.clone(), null);
                        //the list the were gonna be cloned will get next to keep shifting position
			end = end.next;
			temp = temp.next;
		}
		// Now the entire list is created, just return its head pointer
		return newHead;
    }
    
    private void changeSize(int S){
        size=S;
    }
   
    
    public void addToStart(Structure C){
        StructureNode newNode= new StructureNode(C, new StructureNode());
        if(head==null){
            newNode.next=head;
            head=newNode;
        }else{
            StructureNode last = head;
            //pointerrrrr

            head= newNode;
            head.next=last;
            
            
        }
        
        
        size++;
    }
    
    public void addAtEnd(Structure C){
        int num = size-1;
        //so you cannot add at the end? Why??????
        StructureNode newNode= new StructureNode(C, new StructureNode());
        if(head==null){
            addToStart(C);
        }else{
                StructureNode current = this.head;
                for(int i=0; i<num;i++){
                    //it will reach to the index position :3
                    current= current.next;
                }
                newNode.next= current.next;
                current.next=newNode;
                size++;
           
        }
    }
    
    
    
    public void append(StructureList C){
        size+= C.size;
        if(head==null){
            head= C.head;
        }else{
            StructureNode current = this.head;
            StructureNode currentC= C.head;
            while(current.next!=null){
                //it will reach to the index position :3
                current= current.next;
            }
            current.next=C.head;
            C.head=null;
        }
        
    }
    
   
    
    public void showListContents(){
        String header= "The current size of the list is "+size+" Here are the contents of the list"
                +"\n=====================================================================================\n";
        String body="";
        int i=0;
        StructureNode last = head;
        while(last != null){
            body+= "["+last.sObj.getClass().getSimpleName()+ "year: "+last.sObj.getYearOfCreation() +"] ===>";
            last= last.next;
            i++;
        }
        
        body+=" X";
        System.out.println(header+body);
    }
    
   
    
    public int getSize(){
        return size;
    }
    
    static class StructureNode{
        public Structure sObj;
        public StructureNode next;
        
        public StructureNode(){
            sObj=null;
            next=null;
        }
        public StructureNode(Structure object, StructureNode node){
            sObj= object;
            next=node;
        }
        
        
        
        
        public StructureNode getNext(){
            return next;
        }
        public void changeNext(StructureNode C){
            next= C;
        }
        public void changeCellphone(Structure C){
            sObj= C;
        }
        public Structure getCellphone(){
            return this.sObj;
        }
    }
    
}
