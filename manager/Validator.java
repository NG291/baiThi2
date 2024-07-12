package manager;

public class Validator {

    public static void validatePrice(double price) throws InvalidDataException {
        if (price <= 0) {
            throw new InvalidDataException("Price must be a positive number.");
        }
    }

    public static void validateQuantity(int quantity) throws InvalidDataException {
        if (quantity <= 0) {
            throw new InvalidDataException("The quantity must be positive.");
        }
    }

    public static void validatePortableCountry(String portableCountry) throws InvalidDataException {
        if (portableCountry.equalsIgnoreCase("Viet Nam")) {
            throw new InvalidDataException("Cannot be used in Vietnam.");
        }
    }
    public static void validateWarrantyPeriod(int warrantyPeriod) throws InvalidDataException {
        try {

            if (warrantyPeriod <= 0 || warrantyPeriod > 730) {
                throw new InvalidDataException("The warranty period must be a positive number and not exceed 730 days.");
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Thời gian bảo hành phải là một số nguyên.");
        }
    }
}