import { useNavigate } from 'react-router';
import { useState } from 'react';
import FileDownloadOutlinedIcon
  from '@mui/icons-material/FileDownloadOutlined';
import PictureAsPdfOutlinedIcon
  from '@mui/icons-material/PictureAsPdfOutlined';
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

const STATUS_CHIP_WIDTH = 110;

function ReportsPage() {
  const [dateRange, setDateRange] = useState('LAST_30_DAYS');
  const [page, setPage] = useState(0);
  const [rowsPerPage, setRowsPerPage] = useState(10);
  const navigate = useNavigate();

  return (
    <Stack spacing={2}>
	<Box
	  sx={{
	    display: 'flex',
	    flexDirection: {
	      xs: 'column',
	      sm: 'row',
	    },
	    justifyContent: 'space-between',
	    alignItems: {
	      xs: 'flex-start',
	      sm: 'center',
	    },
	    gap: 1.5,
	  }}
	>
	  <Box>
	    <Typography
	      variant="h4"
	      component="h1"
	      sx={{
	        color: 'primary.dark',
	        fontWeight: 700,
	      }}
	    >
	      Reports
	    </Typography>

	    <Typography
	      variant="body1"
	      color="text.secondary"
	      sx={{
	        mt: 0.5,
	      }}
	    >
	      View and analyze reconciliation, sales and collection records.
	    </Typography>
	  </Box>

	  <Box
	    sx={{
	      display: 'flex',
	      gap: 1,
	      flexWrap: 'wrap',
	    }}
	  >
	    <Button
	      variant="outlined"
	      startIcon={<FileDownloadOutlinedIcon />}
	      onClick={() => {
	        // Prototype only.
	      }}
	    >
	      Export Excel
	    </Button>

	    <Button
	      variant="outlined"
	      startIcon={<PictureAsPdfOutlinedIcon />}
	      onClick={() => {
	        // Prototype only.
	      }}
	    >
	      Export PDF
	    </Button>
	  </Box>
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
          Filters
        </Typography>

        <Box
          sx={{
            display: 'grid',
            gridTemplateColumns: {
              xs: '1fr',
              sm: 'repeat(2, minmax(0, 1fr))',
              lg: '1.1fr 1.1fr 1.1fr 0.9fr 0.9fr 1.1fr auto auto',
            },
            gap: 1.5,
            alignItems: 'center',
          }}
        >
          <FormControl fullWidth size="small">
            <InputLabel id="reports-date-range-label">
              Date Range
            </InputLabel>

            <Select
              labelId="reports-date-range-label"
              label="Date Range"
              value={dateRange}
              onChange={(event) => {
                setDateRange(event.target.value);
                setPage(0);
              }}
            >
              <MenuItem value="TODAY">
                Today
              </MenuItem>

              <MenuItem value="LAST_7_DAYS">
                Last 7 Days
              </MenuItem>

              <MenuItem value="LAST_30_DAYS">
                Last 30 Days
              </MenuItem>

              <MenuItem value="LAST_90_DAYS">
                Last 90 Days
              </MenuItem>

              <MenuItem value="CUSTOM">
                Custom Range
              </MenuItem>
            </Select>
          </FormControl>

		  <FormControl fullWidth size="small">
		    <InputLabel id="reports-station-label">
		      Station
		    </InputLabel>

		    <Select
		      labelId="reports-station-label"
		      label="Station"
		      defaultValue="ALL"
		    >
		      <MenuItem value="ALL">
		        All
		      </MenuItem>

		      <MenuItem value="DEMO_STATION">
		        Demo Station
		      </MenuItem>

		      <MenuItem value="STATION_02">
		        Station 02
		      </MenuItem>
		    </Select>
		  </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="reports-employee-label">
              Employee
            </InputLabel>

            <Select
              labelId="reports-employee-label"
              label="Employee"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">
                All
              </MenuItem>

              <MenuItem value="SUJITH">
                Sujith
              </MenuItem>

              <MenuItem value="SONU">
                Sonu
              </MenuItem>

              <MenuItem value="RAMESH">
                Ramesh
              </MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="reports-shift-label">
              Shift
            </InputLabel>

            <Select
              labelId="reports-shift-label"
              label="Shift"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">
                All
              </MenuItem>

              <MenuItem value="SHIFT_1">
                Shift 1
              </MenuItem>

              <MenuItem value="SHIFT_2">
                Shift 2
              </MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="reports-result-label">
              Result
            </InputLabel>

            <Select
              labelId="reports-result-label"
              label="Result"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">
                All
              </MenuItem>

              <MenuItem value="MATCHED">
                Matched
              </MenuItem>

              <MenuItem value="SHORTAGE">
                Shortage
              </MenuItem>

              <MenuItem value="EXCESS">
                Excess
              </MenuItem>
            </Select>
          </FormControl>

          <FormControl fullWidth size="small">
            <InputLabel id="reports-workflow-status-label">
              Workflow Status
            </InputLabel>

            <Select
              labelId="reports-workflow-status-label"
              label="Workflow Status"
              defaultValue="ALL"
            >
              <MenuItem value="ALL">
                All
              </MenuItem>

              <MenuItem value="SUBMITTED">
                Submitted for Review
              </MenuItem>

              <MenuItem value="LEVEL_1_APPROVED">
                Level-1 Approved
              </MenuItem>

              <MenuItem value="RETURNED">
                Returned for Correction
              </MenuItem>

              <MenuItem value="FINAL_APPROVED">
                Final Approved
              </MenuItem>
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
			  '1.1fr 1.1fr 0.9fr 1fr 1fr 1fr 1fr 1.3fr 110px',
            gap: 2,
            px: 2,
            py: 1.5,
            backgroundColor: 'background.default',
            borderBottom: 1,
            borderColor: 'divider',
          }}
        >
          <HeaderCell>Shift Date</HeaderCell>
          <HeaderCell>Employee</HeaderCell>
          <HeaderCell>Shift</HeaderCell>
          <HeaderCell>Sales</HeaderCell>
          <HeaderCell>Collections</HeaderCell>
          <HeaderCell>Difference</HeaderCell>
          <HeaderCell>Result</HeaderCell>
          <HeaderCell>Workflow Status</HeaderCell>
		  <HeaderCell>Action</HeaderCell>
        </Box>

        <ReportRow
          shiftDate="19-Aug-2026"
          employee="Sujith"
          shift="Shift 1"
          sales="₹ 43,250"
          collections="₹ 42,750"
          difference="- ₹ 500"
          differenceType="negative"
          result="SHORTAGE"
          resultColor="error"
          workflowStatus="FINAL APPROVED"
          showTopBorder={false}
		  onView={() =>
		      navigate('/app/reports/detail')
		    }
        />

        <ReportRow
          shiftDate="19-Aug-2026"
          employee="Sonu"
          shift="Shift 2"
          sales="₹ 39,800"
          collections="₹ 39,800"
          difference="₹ 0"
          differenceType="neutral"
          result="MATCHED"
          resultColor="success"
          workflowStatus="FINAL APPROVED"
		  onView={() =>
		      navigate('/app/reports/detail')
		    }
        />

        <ReportRow
          shiftDate="18-Aug-2026"
          employee="Ramesh"
          shift="Shift 1"
          sales="₹ 41,200"
          collections="₹ 41,450"
          difference="+ ₹ 250"
          differenceType="positive"
          result="EXCESS"
          resultColor="warning"
          workflowStatus="RETURNED"
		  onView={() =>
		      navigate('/app/reports/detail')
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
      sx={{
        fontWeight: 700,
      }}
    >
      {children}
    </Typography>
  );
}

type ReportRowProps = {
  shiftDate: string;
  employee: string;
  shift: string;
  sales: string;
  collections: string;
  difference: string;
  differenceType: 'negative' | 'positive' | 'neutral';
  result: 'SHORTAGE' | 'MATCHED' | 'EXCESS';
  resultColor: 'error' | 'success' | 'warning';
  workflowStatus: string;
  onView: () => void;
  showTopBorder?: boolean;
};

function ReportRow({
  shiftDate,
  employee,
  shift,
  sales,
  collections,
  difference,
  differenceType,
  result,
  resultColor,
  workflowStatus,
  onView,
  showTopBorder = true,
}: ReportRowProps) {
  const differenceColor =
    differenceType === 'negative'
      ? 'error.main'
      : differenceType === 'positive'
        ? 'warning.main'
        : 'text.primary';

  return (
    <Box
      sx={{
        display: 'grid',
		gridTemplateColumns:
		  '1.1fr 1.1fr 0.9fr 1fr 1fr 1fr 1fr 1.3fr 110px',
        gap: 2,
        px: 2,
        py: 1.75,
        alignItems: 'center',
        borderTop: showTopBorder ? 1 : 0,
        borderColor: 'divider',
      }}
    >
      <Typography variant="body2">
        {shiftDate}
      </Typography>

      <Typography
        variant="body2"
        sx={{
          fontWeight: 600,
        }}
      >
        {employee}
      </Typography>

      <Typography variant="body2">
        {shift}
      </Typography>

      <Typography variant="body2">
        {sales}
      </Typography>

      <Typography variant="body2">
        {collections}
      </Typography>

      <Typography
        variant="body2"
        sx={{
          fontWeight: 700,
          color: differenceColor,
        }}
      >
        {difference}
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

      <Typography
        variant="body2"
        sx={{
          fontWeight: 600,
        }}
      >
        {workflowStatus}
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

export default ReportsPage;