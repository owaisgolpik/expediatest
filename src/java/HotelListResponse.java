/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author golpik
 */

public class HotelListResponse
{
    private HotelList HotelList;

    private String customerSessionId;

    private String moreResultsAvailable;

    private String numberOfRoomsRequested;
    
    
    public HotelList getHotelList ()
    {
        return HotelList;
    }

    public void setHotelList (HotelList HotelList)
    {
        this.HotelList = HotelList;
    }

    public String getCustomerSessionId ()
    {
        return customerSessionId;
    }

    public void setCustomerSessionId (String customerSessionId)
    {
        this.customerSessionId = customerSessionId;
    }

    public String getMoreResultsAvailable ()
    {
        return moreResultsAvailable;
    }

    public void setMoreResultsAvailable (String moreResultsAvailable)
    {
        this.moreResultsAvailable = moreResultsAvailable;
    }

    public String getNumberOfRoomsRequested ()
    {
        return numberOfRoomsRequested;
    }

    public void setNumberOfRoomsRequested (String numberOfRoomsRequested)
    {
        this.numberOfRoomsRequested = numberOfRoomsRequested;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [HotelList = "+HotelList+", customerSessionId = "+customerSessionId+", moreResultsAvailable = "+moreResultsAvailable+", numberOfRoomsRequested = "+numberOfRoomsRequested+"]";
    }
}