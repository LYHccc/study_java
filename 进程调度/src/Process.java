import java.util.Comparator;
public class Process implements Comparable{
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Process p = (Process)o;
		return this.arriveTime - p.arriveTime;
	}

	@Override
	public String toString() {
		return "Process [arriveTime=" + arriveTime + ", finishTime="
				+ finishTime + ", name=" + name + ", roundTime=" + roundTime
				+ ", serveTime=" + serveTime + ", weightTime=" + weightTime
				+ "]";
	}

	String name;
	int arriveTime;   //到达时间
	int serveTime;    //服务时间
	int finishTime;   //完成时间
	int roundTime;    //周转时间
	double weightTime;   //带权周转时间

	public Process(){
	}

	public Process(String name, int arriveTime, int seveTime){
		this.name = name;
		this.arriveTime = arriveTime;
		this.serveTime = serveTime;
	}
}
