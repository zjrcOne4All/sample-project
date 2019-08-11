package com.one4all.datacenter.connector.service.domain.model.dto;

import com.one4all.datacenter.connector.service.domain.entity.h2.BiOrderTable;
import lombok.Data;

import java.util.List;

@Data
public class FindOrderListResponse {

    private List<BiOrderTable> orderList;

}
