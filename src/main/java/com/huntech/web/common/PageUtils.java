package com.huntech.web.common;

import com.huntech.pvs.core.feature.orm.mybatis.Page;
import java.util.List;


public class PageUtils {

   public static <T> void  setPage(List<T> list ,Integer totalCount,Integer pageSize,Page<T> page){
       /*if(list==null || list.size()<1){
           return null;
       }*/
       int mod=totalCount%pageSize;
       int totalPages=0;
       if(mod!=0){
           totalPages=1;
       }
       totalPages+=totalCount/pageSize;
       page.setResult(list);
       page.setTotalCount(totalCount);
       page.setTotalPages(totalPages);
//       return  page;
   }

}
