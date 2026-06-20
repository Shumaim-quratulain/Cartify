package org.ecommerce.sbecom.exceptions;

public class ResourcesNotFoundException extends RuntimeException {
    String resourceName;
    String Field;
    String FieldName;
    Long FieldId;
   public ResourcesNotFoundException(String resourceName, String field, String fieldName) {
       super(String.format("%s not found with %s : '%s'", resourceName, field, fieldName));
       this.resourceName = resourceName;
        this.Field = field;
        this.FieldName = fieldName;
   }
   public ResourcesNotFoundException(String resourceName, String field, Long FieldId) {
       super(String.format("%s not found with %s : '%s'", resourceName, field, FieldId));
       this.resourceName = resourceName;
       this.Field = field;
       this.FieldId = FieldId;
   }
   public ResourcesNotFoundException() {}

}
