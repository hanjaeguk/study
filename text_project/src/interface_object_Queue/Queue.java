package interface_object_Queue;

public interface Queue {
	public abstract int size(); // 원소 개수
	
	public abstract Object top(); // 읽기만!
	
	public abstract Object pop(); // 읽고 삭제
	
	public abstract boolean push(Object ob); //삽입
	
	public abstract boolean empty(); //확인 
	

}
