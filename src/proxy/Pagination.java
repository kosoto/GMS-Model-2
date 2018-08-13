package proxy;
import lombok.Data;
import service.MemberServiceImpl;
@Data
public class Pagination implements Proxy{
	int pageNum,count,pageSize,blockSize,beginPage,endPage,beginRow,endRow,prevBlock,nextBlock;
	boolean existPrev,exisNext; 
	
	@Override
	public void carryOut(Object o) {
		this.pageNum = Integer.parseInt(((String) o).split("/")[0]); 
		this.pageSize = 5; 
		this.blockSize = 5;
		if(((String)o).split("/").length>1) {
			this.count = MemberServiceImpl.getInstance().count((String) o);
		}else {
			this.count = MemberServiceImpl.getInstance().count();
		}
		this.beginPage = Math.floorDiv(pageNum-1, pageSize)*pageSize+1;
		this.endPage = (count>(beginPage+(blockSize-1))*pageSize)?
				beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize));
		this.beginRow = (pageNum-1)*pageSize+1;
		this.endRow = (count>pageNum*pageSize)?pageNum*pageSize:count;
		this.prevBlock = beginPage -1;
		this.nextBlock = endPage +1;
		this.existPrev = (beginPage>1);
		this.exisNext = (count>endPage*5);
		
	}
}
