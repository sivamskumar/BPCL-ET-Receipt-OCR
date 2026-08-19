import { useState } from 'react';

import {
  Box,
  Button,
  Chip,
  FormControl,
  InputLabel,
  MenuItem,
  Paper,
  Select,
  Stack,
  TablePagination,
  TextField,
  Typography,
} from '@mui/material';

import { useNavigate } from 'react-router';

const STATUS_CHIP_WIDTH = 100;
const DECISION_CHIP_WIDTH = 110;

function ReviewHistoryPage() {
  const navigate = useNavigate();

  const [dateRange, setDateRange] = useState('LAST_30_DAYS');
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);

  return (
    <Stack spacing={2}>
      <Box>
        <Typography
          variant="h4"
          component="h1"
          sx={{
            color: 'primary.dark',
            fontWeight: 700,
          }}
        >
          Review History
        </Typography>

        <Typography
          variant="body1"
          color="text.secondary"
          sx={{ mt: 0.5 }}
        >
          View completed Level-1 reconciliation review decisions.
        </Typography>
      </Box>

      {/* Filters */}
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
          Filters
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(2, minmax(0, 1fr))',
              lg: '1.2fr 1.2fr 1fr 1fr auto auto',
            },
            gap: 1.5,
            alignItems: 'center',
          }}
        >
          <FormControl fullWidth size="small">
            <InputLabel id="review-history-date-range-label">
              Date Range
            </InputLabel>

            <Select
              labelId="review-history-date-range-label"
              label="Date Range"
              value={dateRange}
              onChange={(event) => {
                setDateRange(event.target.value);
                setPage(0);
              }}
            >
              <MenuItem value="TODAY">Today</MenuItem>
              <MenuItem value="LAST_7_DAYS">Last 7 Days</MenuItem>
              <MenuItem value="LAST_30_DAYS">Last 30 Days</MenuItem>
              <MenuItem value="LAST_90_DAYS">Last 90 Days</MenuItem>
              <MenuItem value="CUSTOM">Custom Range</MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="review-history-employee-label">
              Employee
            </InputLabel>

            <Select
              labelId="review-history-employee-label"
              label="Employee"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">All</MenuItem>
              <MenuItem value="SUJITH">Sujith</MenuItem>
              <MenuItem value="SONU">Sonu</MenuItem>
              <MenuItem value="RAMESH">Ramesh</MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="review-history-result-label">
              Result
            </InputLabel>

            <Select
              labelId="review-history-result-label"
              label="Result"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">All</MenuItem>
              <MenuItem value="MATCHED">Matched</MenuItem>
              <MenuItem value="SHORTAGE">Shortage</MenuItem>
              <MenuItem value="EXCESS">Excess</MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="review-history-decision-label">
              Review Decision
            </InputLabel>

            <Select
              labelId="review-history-decision-label"
              label="Review Decision"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">All</MenuItem>
              <MenuItem value="APPROVED">Approved</MenuItem>
              <MenuItem value="RETURNED">Returned</MenuItem>
            </Select>
          </FormControl>

          <Button
            variant="contained"
            sx={{
              whiteSpace: 'nowrap',
              minWidth: 110,
            }}
            onClick={() => setPage(0)}
          >
            Apply Filters
          </Button>

          <Button
            variant="outlined"
            sx={{
              whiteSpace: 'nowrap',
              minWidth: 90,
            }}
            onClick={() => {
              setDateRange('LAST_30_DAYS');
              setPage(0);
            }}
          >
            Reset
          </Button>
        </Box>

        {dateRange === 'CUSTOM' && (
          <Box
            sx={{
              display: 'grid',
              gridTemplateColumns: {
                xs: '1fr',
                sm: 'repeat(2, minmax(0, 1fr))',
              },
              gap: 1.5,
              mt: 1.5,
              maxWidth: {
                xs: '100%',
                md: 600,
              },
            }}
          >
            <TextField
              label="From Date"
              type="date"
              size="small"
              fullWidth
              slotProps={{
                inputLabel: {
                  shrink: true,
                },
              }}
            />

            <TextField
              label="To Date"
              type="date"
              size="small"
              fullWidth
              slotProps={{
                inputLabel: {
                  shrink: true,
                },
              }}
            />
          </Box>
        )}
      </Paper>

      {/* Review History */}
      <Paper
        elevation={0}
        sx={{
          border: 1,
          borderColor: 'divider',
          borderRadius: 2,
          overflow: 'hidden',
        }}
      >
        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns:
              '1.1fr 1.1fr 1fr 1fr 1.1fr 1.35fr 120px',
            gap: 2,
            px: 2,
            py: 1.5,
            backgroundColor: 'background.default',
            borderBottom: 1,
            borderColor: 'divider',
          }}
        >
          <HeaderCell>Employee</HeaderCell>
          <HeaderCell>Shift Date</HeaderCell>
          <HeaderCell>Shift</HeaderCell>
          <HeaderCell>Result</HeaderCell>
          <HeaderCell>Review Decision</HeaderCell>
          <HeaderCell>Reviewed Date &amp; Time</HeaderCell>
          <HeaderCell>Action</HeaderCell>
        </Box>

        <HistoryRow
          employee="Sujith"
          shiftDate="19-Aug-2026"
          shift="Shift 1"
          result="SHORTAGE"
          resultColor="error"
          decision="APPROVED"
          decisionColor="success"
          reviewedDateTime="19-Aug-2026 13:55"
          showTopBorder={false}
          onView={() =>
            navigate('/app/reviews/history/detail')
          }
        />

        <HistoryRow
          employee="Sonu"
          shiftDate="19-Aug-2026"
          shift="Shift 2"
          result="MATCHED"
          resultColor="success"
          decision="APPROVED"
          decisionColor="success"
          reviewedDateTime="19-Aug-2026 12:50"
          onView={() =>
            navigate('/app/reviews/history/detail')
          }
        />

        <HistoryRow
          employee="Ramesh"
          shiftDate="18-Aug-2026"
          shift="Shift 1"
          result="EXCESS"
          resultColor="warning"
          decision="RETURNED"
          decisionColor="error"
          reviewedDateTime="18-Aug-2026 16:25"
          onView={() =>
            navigate('/app/reviews/history/detail')
          }
        />

        <TablePagination
          component="div"
          count={47}
          page={page}
          rowsPerPage={rowsPerPage}
          rowsPerPageOptions={[10, 25, 50]}
          onPageChange={(_, newPage) => {
            setPage(newPage);
          }}
          onRowsPerPageChange={(event) => {
            setRowsPerPage(
              Number.parseInt(event.target.value, 10),
            );
            setPage(0);
          }}
        />
      </Paper>
    </Stack>
  );
}

type HeaderCellProps = {
  children: React.ReactNode;
};

function HeaderCell({
  children,
}: HeaderCellProps) {
  return (
    <Typography
      variant="body2"
      sx={{ fontWeight: 700 }}
    >
      {children}
    </Typography>
  );
}

type HistoryRowProps = {
  employee: string;
  shiftDate: string;
  shift: string;
  result: 'SHORTAGE' | 'MATCHED' | 'EXCESS';
  resultColor: 'error' | 'success' | 'warning';
  decision: 'APPROVED' | 'RETURNED';
  decisionColor: 'success' | 'error';
  reviewedDateTime: string;
  onView: () => void;
  showTopBorder?: boolean;
};

function HistoryRow({
  employee,
  shiftDate,
  shift,
  result,
  resultColor,
  decision,
  decisionColor,
  reviewedDateTime,
  onView,
  showTopBorder = true,
}: HistoryRowProps) {
  return (
    <Box
      sx={{
        display: 'grid',
        gridTemplateColumns:
          '1.1fr 1.1fr 1fr 1fr 1.1fr 1.35fr 120px',
        gap: 2,
        px: 2,
        py: 1.75,
        alignItems: 'center',
        borderTop: showTopBorder ? 1 : 0,
        borderColor: 'divider',
      }}
    >
      <Typography
        variant="body2"
        sx={{ fontWeight: 600 }}
      >
        {employee}
      </Typography>

      <Typography variant="body2">
        {shiftDate}
      </Typography>

      <Typography variant="body2">
        {shift}
      </Typography>

      <Chip
        label={result}
        color={resultColor}
        size="small"
        sx={{
          justifySelf: 'start',
          width: STATUS_CHIP_WIDTH,
        }}
      />

      <Chip
        label={decision}
        color={decisionColor}
        size="small"
        sx={{
          justifySelf: 'start',
          width: DECISION_CHIP_WIDTH,
        }}
      />

      <Typography variant="body2">
        {reviewedDateTime}
      </Typography>

      <Button
        variant="outlined"
        size="small"
        onClick={onView}
      >
        View
      </Button>
    </Box>
  );
}

export default ReviewHistoryPage;