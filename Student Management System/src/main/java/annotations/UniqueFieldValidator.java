package annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, Object> {
	private Class<?> entityClass;
    private String fieldName;
    @Override
    public void initialize(UniqueField constraintAnnotation) {
        this.entityClass = constraintAnnotation.entityClass();
        this.fieldName = constraintAnnotation.fieldName();
    }
    @Override
    public boolean isValid(Object fieldValue, ConstraintValidatorContext context) {
        if (fieldValue == null) {
            return true;
        }

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            Long count = session.createQuery(
                    "select count(e) from " + entityClass.getName() + " e where e." + fieldName + " = :fieldValue", Long.class)
                    .setParameter("fieldValue", fieldValue)
                    .uniqueResult();
            return count == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
