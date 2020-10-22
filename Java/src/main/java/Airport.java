// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

import Planes.experimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;


public class Airport {
    private List<? extends Plane> AllPlaneList;



    public List<PassengerPlane> getPassengerPlane() {
        List<? extends Plane> allPlaneList = this.AllPlaneList;
        List<PassengerPlane> passengerPlanesList  = new ArrayList<>();
        for (Plane plane : allPlaneList) {if (plane instanceof PassengerPlane) {passengerPlanesList .add((PassengerPlane) plane);}}
        return passengerPlanesList ;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : AllPlaneList)
        {
           if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
                      
        } 
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPasssengerPlaneList();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (int i = 0; i < passengerPlanes.size(); i++) {
            if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlanes.get(i);
            }
        }
       return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanesList() {
    List<MilitaryPlane> transportMilitaryPlanesList = new ArrayList<>();
    List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    for (int i = 0; i < militaryPlanes.size(); i++) {
        if (plane.getType() == MilitaryType.TRANSPORT) {
            transportMilitaryPlanesList.add(militaryPlanes.get(i));
        }
     }
     return transportMilitaryPlanesList;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanesList = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (int i = 0; i < militaryPlanes.size(); i++) {
                     if (plane.getType() == MilitaryType.BOMBER) {
                bomberMilitaryPlanesList.add(militaryPlanes.get(i));
            }
        }
        return bomberMilitaryPlanesList;

    }

    public List<experimentalPlane> getExperimentalPlanes() {
        List<experimentalPlane> experimentalPlanesList = new ArrayList<>();
        for (Plane plane : AllPlaneList) {
            if (plane instanceof experimentalPlane) {
                experimentalPlanesList.add((experimentalPlane) plane);
            }
        }
        return experimentalPlanesList;
    }


    public Airport sortByMaxDistance() {
        Collections.sort(AllPlaneList, new Comparator<Plane>() {
            public int compare(Plane firstplane, Plane secondplane) {
                return firstplane.Get_Max_Flight_Distance() - secondplane.Get_Max_Flight_Distance();
            }
        });
        return this;
    }


     
     
    public Airport sortByMaxSpeed() {
        Collections.sort(AllPlaneList, new Comparator<Plane>() {
            public int compare(Plane firstplane, Plane secondplane) {
                return firstplane.getMaxSpeed() - secondplane.getMaxSpeed();
            }
        });

        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(AllPlaneList, new Comparator<Plane>() {
            public int compare(Plane firstplane, Plane secondplane) {
                return firstplane.getMinLoadCapacity() - secondplane.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return AllPlaneList;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + AllPlaneList.toString() +
                '}';
    }


    public Airport(List<? extends Plane> planes) {
        this.AllPlaneList = planes;
    }

}
