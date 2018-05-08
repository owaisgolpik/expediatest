public class HotelList
{
    private HotelSummary HotelSummary;

    public HotelSummary getHotelSummary ()
    {
        return HotelSummary;
    }

    public void setHotelSummary (HotelSummary HotelSummary)
    {
        this.HotelSummary = HotelSummary;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [HotelSummary = "+HotelSummary+"]";
    }
}
