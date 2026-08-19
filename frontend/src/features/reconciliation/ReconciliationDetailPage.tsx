import { useState } from 'react';
import ErrorOutlineOutlinedIcon from '@mui/icons-material/ErrorOutlineOutlined';

import {
  Box,
  Button,
  Chip,
  Paper,
  Stack,
  TextField,
  Typography,
} from '@mui/material';

import { prototypeUser } from '../../app/prototype/prototypeUser';
import ApplicationAlert from '../../components/feedback/ApplicationAlert';

function ReconciliationDetailPage() {
	const [employeeRemarks, setEmployeeRemarks] = useState('');
	const [showEmployeeRemarks, setShowEmployeeRemarks] = useState(false);
	const [submittedForReview, setSubmittedForReview] = useState(false);

	const renderActions = () => {
    switch (prototypeUser.role) {
		case 'EMPLOYEE':
		  return (
		    <Button
		      variant="contained"
		      onClick={() => setShowEmployeeRemarks(true)}
		    >
		      Submit Reconciliation
		    </Button>
		  );

      case 'REVIEWER':
        return (
          <Stack
            direction={{
              xs: 'column',
              sm: 'row',
            }}
            spacing={1.5}
          >
            <Button
              variant="outlined"
              color="error"
            >
              Return for Correction
            </Button>

            <Button variant="outlined">
              Approve with Remarks
            </Button>

            <Button variant="contained">
              Approve
            </Button>
          </Stack>
        );

      case 'APPROVER':
        return (
          <Stack
            direction={{
              xs: 'column',
              sm: 'row',
            }}
            spacing={1.5}
          >
            <Button
              variant="outlined"
              color="error"
            >
              Reject with Remarks
            </Button>

            <Button variant="contained">
              Final Approve
            </Button>
          </Stack>
        );

      case 'ADMINISTRATOR':
        return null;
    }
  };

  return (
    <Stack spacing={1.5}>
      <Box>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Reconciliation Detail
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{
            mt: 0.5,
          }}
        >
          Review shift sales, collections and reconciliation status.
        </Typography>
      </Box>

	  {prototypeUser.role === 'EMPLOYEE' && submittedForReview && (
	    <ApplicationAlert
	      severity="success"
	      title="Reconciliation submitted successfully"
	    >
	      <Typography variant="body2">
	        This reconciliation has been submitted for Level-1 review.
	      </Typography>

	      <Box
	        sx={{
	          display: 'grid',
	          gridTemplateColumns: {
	            xs: '1fr',
	            sm: '220px 1fr',
	          },
	          gap: 1.5,
	          mt: 1.25,
	        }}
	      >
	        <Box>
	          <Typography
	            variant="caption"
	            sx={{
	              display: 'block',
	              opacity: 0.8,
	            }}
	          >
	            Workflow Status
	          </Typography>

	          <Typography
	            variant="body2"
	            sx={{
	              fontWeight: 700,
	            }}
	          >
	            SUBMITTED FOR REVIEW
	          </Typography>
	        </Box>

	        <Box>
	          <Typography
	            variant="caption"
	            sx={{
	              display: 'block',
	              opacity: 0.8,
	            }}
	          >
	            Employee Remarks
	          </Typography>

	          <Typography
	            variant="body2"
	            sx={{
	              fontWeight: 600,
	            }}
	          >
	            {employeeRemarks}
	          </Typography>
	        </Box>
	      </Box>
	    </ApplicationAlert>
	  )}

      <Paper
        elevation={0}
        sx={{
          p: 1.75,
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
        }}
      >
        <Typography
          variant="h6"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
            mb: 1,
          }}
        >
          Shift Context
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              md: 'repeat(4, minmax(0, 1fr))',
            },
            gap: 2,
          }}
        >
          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Employee
            </Typography>

            <Typography
              variant="body1"
              sx={{ fontWeight: 600 }}
            >
              Sujith
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Station
            </Typography>

            <Typography
              variant="body1"
              sx={{ fontWeight: 600 }}
            >
              Demo Station
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Shift
            </Typography>

            <Typography
              variant="body1"
              sx={{ fontWeight: 600 }}
            >
              Shift 1
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Dispenser Unit
            </Typography>

            <Typography
              variant="body1"
              sx={{ fontWeight: 600 }}
            >
              DU-01 (A)
            </Typography>
          </Box>
        </Box>
      </Paper>

      <Box
        sx={{
          display: 'grid',
          gridTemplateColumns: {
            xs: '1fr',
            lg: '1fr 1fr',
          },
          gap: 2,
        }}
      >
        <Paper
          elevation={0}
          sx={{
            p: 1.75,
            border: 1,
            borderColor: 'divider',
            borderRadius: 2,
          }}
        >
          <Typography
            variant="h6"
            sx={{
              color: 'primary.dark',
              fontWeight: 700,
              mb: 1,
            }}
          >
            Sales Summary
          </Typography>

		  <Stack spacing={1}>
		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '180px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 600 }}>
		        Petrol Sales:
		      </Typography>

		      <Typography variant="body2">
		        ₹ 24,500
		      </Typography>
		    </Box>

		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '180px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 600 }}>
		        Diesel Sales:
		      </Typography>

		      <Typography variant="body2">
		        ₹ 18,750
		      </Typography>
		    </Box>

		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '180px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 700 }}>
		        Total Sales:
		      </Typography>

		      <Typography variant="body2">
		        ₹ 43,250
		      </Typography>
		    </Box>
		  </Stack>
        </Paper>

        <Paper
          elevation={0}
          sx={{
            p: 1.75,
            border: 1,
            borderColor: 'divider',
            borderRadius: 2,
          }}
        >
          <Typography
            variant="h6"
            sx={{
              color: 'primary.dark',
              fontWeight: 700,
              mb: 1,
            }}
          >
            Collections
          </Typography>

		  <Stack spacing={1}>
		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '200px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 600 }}>
		        Cash:
		      </Typography>

		      <Typography variant="body2">
		        ₹ 18,000
		      </Typography>
		    </Box>

		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '200px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 600 }}>
		        TID Total (UPI + Card):
		      </Typography>

		      <Typography variant="body2">
		        ₹ 24,750
		      </Typography>
		    </Box>

		    <Box
		      sx={{
		        display: 'grid',
		        gridTemplateColumns: '200px auto',
		        alignItems: 'center',
		      }}
		    >
		      <Typography variant="body2" sx={{ fontWeight: 700 }}>
		        Total Collections:
		      </Typography>

		      <Typography variant="body2">
		        ₹ 42,750
		      </Typography>
		    </Box>
		  </Stack>
        </Paper>
      </Box>

      <Paper
        elevation={0}
        sx={{
          p: 1.75,
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
        }}
      >
        <Typography
          variant="h6"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
            mb: 1,
          }}
        >
          Reconciliation Summary
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(2, minmax(0, 1fr))',
              lg: 'repeat(4, minmax(0, 1fr))',
            },
            gap: 2,
          }}
        >
          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Expected Amount
            </Typography>

            <Typography
              variant="h6"
              sx={{ fontWeight: 700 }}
            >
              ₹ 43,250
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Actual Amount
            </Typography>

            <Typography
              variant="h6"
              sx={{ fontWeight: 700 }}
            >
              ₹ 42,750
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Difference
            </Typography>

            <Typography
              variant="h6"
              sx={{
                fontWeight: 700,
                color: 'error.main',
              }}
            >
              - ₹ 500
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              color="text.secondary"
            >
              Status
            </Typography>

            <Box sx={{ mt: 0.5 }}>
              <Chip
                label="SHORTAGE"
                color="error"
                size="small"
                icon={<ErrorOutlineOutlinedIcon />}
              />
            </Box>
          </Box>
        </Box>
      </Paper>

	  {prototypeUser.role === 'EMPLOYEE' && showEmployeeRemarks && (
	    <Paper
	      elevation={0}
	      sx={{
	        p: 1.75,
	        border: 1,
	        borderColor: 'divider',
	        borderRadius: 2,
	      }}
	    >
	      <Typography
	        variant="h6"
	        sx={{
	          color: 'primary.dark',
	          fontWeight: 700,
	          mb: 1,
	        }}
	      >
	        Shortage Remarks
	      </Typography>

	      <Typography
	        variant="body2"
	        color="text.secondary"
	        sx={{
	          mb: 1.25,
	        }}
	      >
	        A shortage of ₹ 500 has been identified. Add remarks before submitting
	        the reconciliation for review.
	      </Typography>

	      <TextField
	        label="Remarks"
	        multiline
	        minRows={2}
	        fullWidth
	        value={employeeRemarks}
	        onChange={(event) => setEmployeeRemarks(event.target.value)}
	        placeholder="Enter reason or remarks for the shortage."
	      />

	      <Box
	        sx={{
	          display: 'flex',
	          justifyContent: 'flex-end',
	          gap: 1.5,
	          mt: 1.5,
	        }}
	      >
	        <Button
	          variant="outlined"
	          onClick={() => {
	            setShowEmployeeRemarks(false);
	            setEmployeeRemarks('');
	          }}
	        >
	          Cancel
	        </Button>

			<Button
			  variant="contained"
			  disabled={!employeeRemarks.trim()}
			  onClick={() => {
			    setSubmittedForReview(true);
			    setShowEmployeeRemarks(false);
			  }}
			>
			  Submit to Reviewer
			</Button>
	      </Box>
	    </Paper>
	  )}

      {(prototypeUser.role === 'REVIEWER' ||
        prototypeUser.role === 'APPROVER') && (
        <Paper
          elevation={0}
          sx={{
            p: 2,
            border: 1,
            borderColor: 'divider',
            borderRadius: 2,
          }}
        >
          <Typography
            variant="h6"
            sx={{
              color: 'primary.dark',
              fontWeight: 700,
              mb: 1.5,
            }}
          >
            Remarks
          </Typography>

          <TextField
            label="Remarks"
            multiline
            minRows={3}
            fullWidth
            placeholder="Enter remarks for this decision."
          />
        </Paper>
      )}

	  {!(
	    prototypeUser.role === 'EMPLOYEE' &&
	    (showEmployeeRemarks || submittedForReview)
	  ) && (
	    <Box
	      sx={{
	        display: 'flex',
	        justifyContent: 'flex-end',
	      }}
	    >
	      {renderActions()}
	    </Box>
	  )}
    </Stack>
  );
}

export default ReconciliationDetailPage;