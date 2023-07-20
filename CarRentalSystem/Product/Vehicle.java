package CarRentalSystem.Product;

import java.util.Date;

public class Vehicle {
	int vehicleId;
	int vehicleNo; 
	VehicleType vehicleType;
	String companyName; 
	String modelName;
	Date manufacturingDate;
	int average; 
	int cc;
	int dailyRentalCost;
	int hourlyRentalCost; 
	int kmDriven; 
	int noOfSeat;
	Status status;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(int vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Date getManufacturingDate() {
		return manufacturingDate;
	}
	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}
	public int getAverage() {
		return average;
	}
	public void setAverage(int average) {
		this.average = average;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getDailyRentalCost() {
		return dailyRentalCost;
	}
	public void setDailyRentalCost(int dailyRentalCost) {
		this.dailyRentalCost = dailyRentalCost;
	}
	public int getHourlyRentalCost() {
		return hourlyRentalCost;
	}
	public void setHourlyRentalCost(int hourlyRentalCost) {
		this.hourlyRentalCost = hourlyRentalCost;
	}
	public int getKmDriven() {
		return kmDriven;
	}
	public void setKmDriven(int kmDriven) {
		this.kmDriven = kmDriven;
	}
	public int getNoOfSeat() {
		return noOfSeat;
	}
	public void setNoOfSeat(int noOfSeat) {
		this.noOfSeat = noOfSeat;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	} 
	
	
}
