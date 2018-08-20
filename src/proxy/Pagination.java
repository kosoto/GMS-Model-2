package proxy;
import java.util.Map;

import lombok.Data;
@Data
public class Pagination implements Proxy{
	int pageNum,count,pageSize,blockSize,beginPage,endPage,beginRow,endRow,prevBlock,nextBlock;
	boolean existPrev,exisNext; 
	
	@Override
	public void carryOut(Object o) {
		@SuppressWarnings("unchecked")
		Map<String,Object> map = ((Map<String, Object>)o);
		pageNum = Integer.parseInt((String) map.get("pageNum"));
		pageSize = 5; 
		blockSize = 5;
		count =  (int) map.get("count");
		beginPage = Math.floorDiv(pageNum-1, pageSize)*pageSize+1;
		endPage = (count>(beginPage+(blockSize-1))*pageSize)?
				beginPage+(blockSize-1):(int)(Math.ceil(count/(double)pageSize));
		beginRow = (pageNum-1)*pageSize+1;
		endRow = (count>pageNum*pageSize)?pageNum*pageSize:count;
		prevBlock = beginPage -1;
		nextBlock = endPage +1;
		existPrev = (beginPage>1);
		exisNext = (count>endPage*5);
		
	}
}
