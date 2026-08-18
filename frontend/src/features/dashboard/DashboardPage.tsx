
import { prototypeUser } from '../../app/prototype/prototypeUser';
import EmployeeDashboard from './EmployeeDashboard';
import ReviewerDashboard from './ReviewerDashboard';
import ApproverDashboard from './ApproverDashboard';
import AdministratorDashboard from './AdministratorDashboard';

function DashboardPage() {
  switch (prototypeUser.role) {
    case 'EMPLOYEE':
      return <EmployeeDashboard />;

	  case 'REVIEWER':
	    return <ReviewerDashboard />;

		case 'APPROVER':
		  return <ApproverDashboard />;

		  case 'ADMINISTRATOR':
		    return <AdministratorDashboard />;
  }
}

export default DashboardPage;