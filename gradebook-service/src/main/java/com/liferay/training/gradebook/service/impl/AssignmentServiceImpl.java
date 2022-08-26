package com.liferay.training.gradebook.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.training.gradebook.model.Assignment;
import com.liferay.training.gradebook.service.base.AssignmentServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the assignment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.training.gradebook.service.AssignmentService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AssignmentServiceBaseImpl
 */
@Component(
    property = {
        "json.web.service.context.name=gradebook",
        "json.web.service.context.path=Assignment"
    },
    service = AopService.class
)
public class AssignmentServiceImpl extends AssignmentServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use <code>com.liferay.training.gradebook.service.AssignmentServiceUtil</code> to access the assignment remote service.
     */
    public Assignment addAssignment(
        long groupId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
        Date dueDate, ServiceContext serviceContext)
        throws PortalException {

        return assignmentLocalService.addAssignment(
            groupId, titleMap, descriptionMap, dueDate, serviceContext);
    }

    public Assignment deleteAssignment(long assignmentId)
        throws PortalException {

        Assignment assignment =
            assignmentLocalService.getAssignment(assignmentId);

        return assignmentLocalService.deleteAssignment(assignment);
    }

    public Assignment getAssignment(long assignmentId)
        throws PortalException {

        Assignment assignment =
            assignmentLocalService.getAssignment(assignmentId);

        return assignment;
    }

    public List<Assignment> getAssignmentsByGroupId(long groupId) {

        return assignmentPersistence.findByGroupId(groupId);
    }

    public List<Assignment> getAssignmentsByKeywords(
        long groupId, String keywords, int start, int end,
        OrderByComparator<Assignment> orderByComparator) {

        return assignmentLocalService.getAssignmentsByKeywords(
            groupId, keywords, start, end, orderByComparator);
    }

    public long getAssignmentsCountByKeywords(long groupId, String keywords) {

        return assignmentLocalService.getAssignmentsCountByKeywords(
            groupId, keywords);
    }

    public Assignment updateAssignment(
        long assignmentId, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap,
        Date dueDate, ServiceContext serviceContext)
        throws PortalException {

        return assignmentLocalService.updateAssignment(
            assignmentId, titleMap, descriptionMap, dueDate, serviceContext);
    }    
}