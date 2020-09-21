package com.yueqian.tickets.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yueqian.tickets.common.ParamCreater;
import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.domain.PageVO;
import com.yueqian.tickets.mapper.EmployeeMapper;
import com.yueqian.tickets.service.SplitPageService;

@Service("empSplitPageService")
public class EmpSplitPageServiceImpl implements SplitPageService<EmployeeVO> {
	@Resource
	private EmployeeMapper empMapper;

	@Override
	public void setRowCount(String condition, String orderCol, String orderSeq, PageVO<EmployeeVO> pageVO) {
		Map<String, Object> param = ParamCreater.createParamMap(new String[] { "condition", "orderCol", "orderSeq" },
				new Object[] { condition, orderCol, orderSeq });
		// 获取总条数
		int rowCount = empMapper.getRowCount(param);
		// 计算总页数
		int pageCount = rowCount / pageVO.getPageSize();
		if (rowCount % pageVO.getPageSize() != 0) {
			pageCount++;
		}
		pageVO.setPageCount(pageCount);

	}

	@Override
	public void setPageContentList(PageVO<EmployeeVO> pageVO, String condition, String orderCol, String orderSeq) {
		// 查询分页内容
		// 当前页码
		int nowPageNum = pageVO.getNowPageNum();
		// 每页几条
		int pageSize = pageVO.getPageSize();
		// 计算起始和终止行
		int startRow = pageSize * (nowPageNum - 1) + 1;
		int endRow = pageSize * nowPageNum;

		Map<String, Object> param = ParamCreater.createParamMap(
				new String[] { "condition", "orderCol", "orderSeq", "startRow", "endRow" },
				new Object[] { condition, orderCol, orderSeq, startRow, endRow });
		
		pageVO.setContentList(empMapper.getEmps(param));

	}

}
