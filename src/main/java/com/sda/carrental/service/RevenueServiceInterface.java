package com.sda.carrental.service;

import com.sda.carrental.models.RevenueEntity;
import java.util.Optional;

public interface RevenueServiceInterface {

    RevenueEntity createRevenue(RevenueEntity revenue);

    Optional<RevenueEntity> getRevenue(Integer revenueId);

    RevenueEntity updateRevenue(RevenueEntity revenue, Integer revenueId);

    void deleteRevenue(Integer revenueId);
}
