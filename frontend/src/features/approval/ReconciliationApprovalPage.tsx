import { useRef, useState } from 'react';

import {
  Box,
  Button,
  Chip,
  Paper,
  Stack,
  TextField,
  Typography,
} from '@mui/material';

import ApplicationAlert from '../../components/feedback/ApplicationAlert';

type ApprovalResult = 'APPROVED' | 'RETURNED' | undefined;

function ReconciliationApprovalPage() {
  const pageTopRef = useRef<HTMLDivElement>(null);
  const [approverRemarks, setApproverRemarks] = useState('');
  const [approvalResult, setApprovalResult] = useState<ApprovalResult>();

  const scrollToTop = () => {
    requestAnimationFrame(() => {
      pageTopRef.current?.scrollIntoView({
        behavior: 'smooth',
        block: 'start',
      });
    });
  };

  const handleReturnToEmployee = () => {
    if (!approverRemarks.trim()) {
      return;
    }

    setApprovalResult('RETURNED');
    scrollToTop();
  };

  const handleFinalApprove = () => {
    if (!approverRemarks.trim()) {
      return;
    }

    setApprovalResult('APPROVED');
    scrollToTop();
  };

  return (
    <Stack spacing={1.75}>
      <Box ref={pageTopRef}>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Reconciliation Approval
        </Typography>

        <Typography
          variant="body1"
          sx={{
            mt: 0.25,
          }}
        >
          Review the Level-1 decision and make the final approval decision.
        </Typography>
      </Box>

      {approvalResult === 'APPROVED' && (
        <ApplicationAlert
          severity="success"
          title="Reconciliation approved successfully"
        >
          <Typography variant="body2">
            This reconciliation has received final approval.
          </Typography>
        </ApplicationAlert>
      )}

      {approvalResult === 'RETURNED' && (
        <ApplicationAlert
          severity="success"
          title="Reconciliation returned successfully"
        >
          <Typography variant="body2">
            This reconciliation has been returned to the employee for
            correction.
          </Typography>
        </ApplicationAlert>
      )}

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
          Shift Context
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(2, 1fr)',
              md: 'repeat(4, 1fr)',
            },
            gap: 2,
          }}
        >
          <DetailItem
            label="Employee"
            value="Sujith"
          />

          <DetailItem
            label="Station"
            value="Demo Station"
          />

          <DetailItem
            label="Shift"
            value="Shift 1"
          />

          <DetailItem
            label="Dispenser Unit"
            value="DU-01 (A)"
          />
        </Box>
      </Paper>

      <Box
        sx={{
          display: 'grid',
          gridTemplateColumns: {
            xs: '1fr',
            md: '1fr 1fr',
          },
          gap: 1.75,
        }}
      >
        <SummaryCard title="Sales Summary">
          <SummaryRow
            label="Petrol Sales"
            value="₹ 24,500"
          />

          <SummaryRow
            label="Diesel Sales"
            value="₹ 18,750"
          />

          <SummaryRow
            label="Total Sales"
            value="₹ 43,250"
          />
        </SummaryCard>

        <SummaryCard title="Collections">
          <SummaryRow
            label="Cash"
            value="₹ 18,000"
          />

          <SummaryRow
            label="TID Total (UPI + Card)"
            value="₹ 24,750"
          />

          <SummaryRow
            label="Total Collections"
            value="₹ 42,750"
          />
        </SummaryCard>
      </Box>

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
          Reconciliation Summary
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr 1fr',
              md: 'repeat(4, 1fr)',
            },
            gap: 2,
          }}
        >
          <DetailItem
            label="Expected Amount"
            value="₹ 43,250"
          />

          <DetailItem
            label="Actual Amount"
            value="₹ 42,750"
          />

          <Box>
            <Typography variant="caption">
              Difference
            </Typography>

            <Typography
              variant="h6"
              sx={{
                color: 'error.main',
                fontWeight: 700,
              }}
            >
              - ₹ 500
            </Typography>
          </Box>

          <Box>
            <Typography
              variant="caption"
              sx={{
                display: 'block',
                mb: 0.5,
              }}
            >
              Status
            </Typography>

            <Chip
              label="SHORTAGE"
              color="error"
              size="small"
              sx={{
                width: 100,
              }}
            />
          </Box>
        </Box>
      </Paper>

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
            mb: 1.25,
          }}
        >
          Employee Submission
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: '240px 1fr',
            },
            gap: 2,
          }}
        >
          <DetailItem
            label="Workflow Status"
            value="SUBMITTED FOR REVIEW"
          />

          <DetailItem
            label="Employee Remarks"
            value="shortage due to expense"
          />
        </Box>
      </Paper>

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
            mb: 1.25,
          }}
        >
          Level-1 Review
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(3, minmax(0, 1fr))',
            },
            gap: 2,
          }}
        >
          <DetailItem
            label="Reviewer"
            value="Reviewer 1"
          />

          <DetailItem
            label="Decision"
            value="APPROVED"
          />

          <DetailItem
            label="Reviewer Remarks"
            value="Shortage reviewed and forwarded for final approval."
          />
        </Box>
      </Paper>

      {!approvalResult && (
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
              mb: 0.5,
            }}
          >
            Approver Decision
          </Typography>

          <Typography
            variant="body2"
            sx={{
              mb: 1.5,
            }}
          >
            Add remarks and choose the appropriate Level-2 action.
          </Typography>

          <TextField
            label="Approver Remarks"
            value={approverRemarks}
            onChange={(event) =>
              setApproverRemarks(event.target.value)
            }
            multiline
            minRows={2}
            fullWidth
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
              color="error"
              disabled={!approverRemarks.trim()}
              onClick={handleReturnToEmployee}
            >
              Return to Employee
            </Button>

            <Button
              variant="contained"
              disabled={!approverRemarks.trim()}
              onClick={handleFinalApprove}
            >
              Final Approve
            </Button>
          </Box>
        </Paper>
      )}
    </Stack>
  );
}

type DetailItemProps = {
  label: string;
  value: string;
};

function DetailItem({
  label,
  value,
}: DetailItemProps) {
  return (
    <Box>
      <Typography variant="caption">
        {label}
      </Typography>

      <Typography
        variant="body1"
        sx={{
          fontWeight: 700,
        }}
      >
        {value}
      </Typography>
    </Box>
  );
}

type SummaryCardProps = {
  title: string;
  children: React.ReactNode;
};

function SummaryCard({
  title,
  children,
}: SummaryCardProps) {
  return (
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
          mb: 1,
        }}
      >
        {title}
      </Typography>

      <Stack spacing={0.75}>
        {children}
      </Stack>
    </Paper>
  );
}

type SummaryRowProps = {
  label: string;
  value: string;
};

function SummaryRow({
  label,
  value,
}: SummaryRowProps) {
  return (
    <Box
      sx={{
        display: 'grid',
        gridTemplateColumns: '200px 1fr',
        alignItems: 'baseline',
      }}
    >
      <Typography
        variant="body2"
        sx={{
          fontWeight: 700,
        }}
      >
        {label}:
      </Typography>

      <Typography variant="body2">
        {value}
      </Typography>
    </Box>
  );
}

export default ReconciliationApprovalPage;