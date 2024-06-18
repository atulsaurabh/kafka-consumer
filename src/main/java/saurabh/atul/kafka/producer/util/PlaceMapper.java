package saurabh.atul.kafka.producer.util;

public class PlaceMapper
{
    public static String personToPlaceMapper(String person)
    {
        if (person.equalsIgnoreCase("atul saurabh"))
            return "Ahmedabad";
        else
            if (person.equalsIgnoreCase("fedora"))
                return "Linux";
        else
            return "Local";
    }
}
