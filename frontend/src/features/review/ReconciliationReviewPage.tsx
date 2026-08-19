import { useState } from 'react';

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

type ReviewResult = 'APPROVED' | 'RETURNED' | undefined;

function ReconciliationReviewPage() {
  const [reviewerRemarks, setReviewerRemarks] = useState('');
  const [reviewResult, setReviewResult] = useState<ReviewResult>();

  const handleReturnForCorrection = () => {
    if (!reviewerRemarks.trim()) {
      return;
    }

    setReviewResult('RETURNED');
  };

  const handleApprove = () => {
    setReviewResult('APPROVED');
  };

  return (
    <Stack spacing={1.75}>
      <Box>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Reconciliation Review
        </Typography>

        <Typography variant="body1" sx={{ mt: 0.25 }}>
          Review the submitted reconciliation and make a Level-1 decision.
        </Typography>
      </Box>

      {reviewResult === 'APPROVED' && (
        <ApplicationAlert
          severity="success"
          title="Reconciliation approved successfully"
        >
          <Typography variant="body2">
            This reconciliation has been forwarded for Level-2 approval.
          </Typography>
        </ApplicationAlert>
      )}

      {reviewResult === 'RETURNED' && (
        <ApplicationAlert
          severity="success"
          title="Reconciliation returned for correction"
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
          <DetailItem label="Employee" value="Sujith" />
          <DetailItem label="Station" value="Demo Station" />
          <DetailItem label="Shift" value="Shift 1" />
          <DetailItem label="Dispenser Unit" value="DU-01 (A)" />
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
          <SummaryRow label="Petrol Sales" value="₹ 24,500" />
          <SummaryRow label="Diesel Sales" value="₹ 18,750" />
          <SummaryRow label="Total Sales" value="₹ 43,250" />
        </SummaryCard>

        <SummaryCard title="Collections">
          <SummaryRow label="Cash" value="₹ 18,000" />
          <SummaryRow label="TID Total (UPI + Card)" value="₹ 24,750" />
          <SummaryRow label="Total Collections" value="₹ 42,750" />
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
          <DetailItem label="Expected Amount" value="₹ 43,250" />
          <DetailItem label="Actual Amount" value="₹ 42,750" />

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
              sx={{ display: 'block', mb: 0.5 }}
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

      {!reviewResult && (
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
            Reviewer Decision
          </Typography>

          <Typography
            variant="body2"
            sx={{ mb: 1.5 }}
          >
            Add reviewer remarks and choose the appropriate Level-1 action.
          </Typography>

          <TextField
            label="Reviewer Remarks"
            value={reviewerRemarks}
            onChange={(event) =>
              setReviewerRemarks(event.target.value)
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
              onClick={handleReturnForCorrection}
              disabled={!reviewerRemarks.trim()}
            >
              Return for Correction
            </Button>

            <Button
              variant="contained"
              onClick={handleApprove}
            >
              Approve &amp; Forward
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
        sx={{ fontWeight: 700 }}
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
        sx={{ fontWeight: 700 }}
      >
        {label}:
      </Typography>

      <Typography variant="body2">
        {value}
      </Typography>
    </Box>
  );
}

export default ReconciliationReviewPage;