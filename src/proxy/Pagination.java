package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data
public class Pagination implements Proxy{
	int pageNum,count,pageSize,blockSize,beginPage,endPage,beginRow,endRow;
	boolean existPrev,exisNext;
	
	@Override
	public Map<?, ?> carryOut(Map<?, ?> param) {
		Map<String,Object>map = new HashMap<>();
		map.put("beginRow", String.valueOf(beginRow));
		map.put("endRow", String.valueOf(endRow));
		return null;
	}

	


}
