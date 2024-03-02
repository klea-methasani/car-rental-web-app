package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.CustomerNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.enums.CarStatus;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.service.CarServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarServiceInterface {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BranchRepository branchRepository;

    @Override
    public CarEntity createCar(CarEntity car,Long branchId) {
        car.setStatus(CarStatus.AVAILABLE);
        Optional<BranchEntity> branchEntity = branchRepository.findById(Math.toIntExact(branchId));
        if (branchEntity.isEmpty()) {
            throw new RuntimeException("Branch with provided ID does not exist");
        }
        car.setBranchEntity(branchEntity.get());
        car.setReservationEntities(car.getReservationEntities());
        return carRepository.save(car);
    }

    @Override
    public Optional<CarEntity> getCar(Integer carId) {
        return Optional.of(carRepository.findById(carId)).orElseThrow(() -> new EntityNotFoundException("Car not found with this :" + carId));

    }

    @Override
    public void deleteCar(Integer carId) {
        carRepository.deleteById(carId);
    }


    @Override
    public CarEntity updateCar(CarEntity car, Integer carId) {
        if (!carRepository.existsById(carId)) {
            throw new CustomerNotFoundException("You are not able to update  this car because it does not exist");
        }
        Optional<CarEntity> carEntity = carRepository.findById(carId);

        carEntity.get().setModel(carEntity.get().getModel());
        carEntity.get().setColor(carEntity.get().getColor());
        carEntity.get().setBrand(carEntity.get().getBrand());
        carEntity.get().setRental_per_day(carEntity.get().getRental_per_day());
        carEntity.get().setYear(carEntity.get().getYear());

        return carRepository.save(carEntity.get());
    }

    @Override
    public List<CarEntity> getCarsByBranchId(Integer branchId) {
        return branchRepository.findById(branchId).map(BranchEntity::getCarEntities)
                .orElseThrow(() -> new EntityNotFoundException("Car not found"));
    }
}
