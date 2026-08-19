import {
  Box,
  Chip,
  Paper,
  Stack,
  Typography,
} from '@mui/material';

function ReportDetailPage() {
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
	    Reconciliation Report Detail
	  </Typography>

	  <Typography
	    variant="body1"
	    color="text.secondary"
	    sx={{ mt: 0.25 }}
	  >
	    View the complete reconciliation and workflow information.
	  </Typography>
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
            mb: 1.25,
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
            mb: 1.25,
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
              Result
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
              sm: 'repeat(3, minmax(0, 1fr))',
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

          <DetailItem
            label="Submitted Date & Time"
            value="19-Aug-2026 12:40"
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
              sm: 'repeat(4, minmax(0, 1fr))',
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

          <DetailItem
            label="Reviewed Date & Time"
            value="19-Aug-2026 13:55"
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
          Level-2 Approval
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(4, minmax(0, 1fr))',
            },
            gap: 2,
          }}
        >
          <DetailItem
            label="Approver"
            value="Approver 1"
          />

          <Box>
            <Typography
              variant="caption"
              sx={{
                display: 'block',
                mb: 0.5,
              }}
            >
              Final Decision
            </Typography>

            <Chip
              label="APPROVED"
              color="success"
              size="small"
              sx={{
                width: 110,
              }}
            />
          </Box>

          <DetailItem
            label="Approver Remarks"
            value="Shortage accepted after Level-1 review."
          />

          <DetailItem
            label="Decision Date & Time"
            value="19-Aug-2026 14:35"
          />
        </Box>
      </Paper>
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
      <Typography
        variant="caption"
        color="text.secondary"
      >
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

export default ReportDetailPage;