package ua.com.nix.entity;

public class Plane extends AbstractEntity
{
    private PlaneBrand planeBrand;
    private String planeModel;
    private int numberOfPassenger;
    private double weightOfTheTransportedCargo;
    private int numberOfCrew;

    public PlaneBrand getPlaneBrand()
    {
        return planeBrand;
    }

    public void setPlaneBrand(PlaneBrand planeBrand)
    {
        this.planeBrand = planeBrand;
    }

    public String getPlaneModel()
    {
        return planeModel;
    }

    public void setPlaneModel(String planeModel)
    {
        this.planeModel = planeModel;
    }

    public int getNumberOfPassenger()
    {
        return numberOfPassenger;
    }

    public void setNumberOfPassenger(int numberOfPassenger)
    {
        this.numberOfPassenger = numberOfPassenger;
    }

    public double getWeightOfTheTransportedCargo()
    {
        return weightOfTheTransportedCargo;
    }

    public void setWeightOfTheTransportedCargo(double weightOfTheTransportedCargo)
    {
        this.weightOfTheTransportedCargo = weightOfTheTransportedCargo;
    }

    public int getNumberOfCrew()
    {
        return numberOfCrew;
    }

    public void setNumberOfCrew(int numberOfCrew)
    {
        this.numberOfCrew = numberOfCrew;
    }

    @Override
    public String toString()
    {
        return "Plane{" +
                "id=" + getId() + ", " +
                "planeBrand=" + planeBrand +
                ", planeModel='" + planeModel + '\'' +
                ", numberOfPassenger=" + numberOfPassenger +
                ", weightOfTheTransportedCargo=" + weightOfTheTransportedCargo +
                ", numberOfCrew=" + numberOfCrew +
                '}';
    }
}
