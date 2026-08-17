import DashboardOutlinedIcon from '@mui/icons-material/DashboardOutlined';
import ReceiptLongOutlinedIcon from '@mui/icons-material/ReceiptLongOutlined';
import PaymentsOutlinedIcon from '@mui/icons-material/PaymentsOutlined';
import BalanceOutlinedIcon from '@mui/icons-material/BalanceOutlined';

import {
  Box,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
} from '@mui/material';

import { useLocation, useNavigate } from 'react-router';

type NavigationItem = {
  label: string;
  path: string;
  icon: React.ReactNode;
};

const navigationItems: NavigationItem[] = [
  {
    label: 'Dashboard',
    path: '/app/dashboard',
    icon: <DashboardOutlinedIcon />,
  },
  {
    label: 'My Shift',
    path: '/app/shift',
    icon: <ReceiptLongOutlinedIcon />,
  },
  {
    label: 'Collections',
    path: '/app/collections',
    icon: <PaymentsOutlinedIcon />,
  },
  {
    label: 'Reconciliation',
    path: '/app/reconciliation',
    icon: <BalanceOutlinedIcon />,
  },
];

function AppSidebar() {
  const navigate = useNavigate();
  const location = useLocation();

  return (
    <Box
      component="aside"
      sx={{
        width: 260,
        flexShrink: 0,
        backgroundColor: 'primary.dark',
        color: 'primary.contrastText',
      }}
    >
      <List
        sx={{
          px: 1.5,
          py: 2,
        }}
      >
        {navigationItems.map((item) => {
          const selected = location.pathname === item.path;

          return (
            <ListItemButton
              key={item.path}
              selected={selected}
              onClick={() => navigate(item.path)}
              sx={{
                mb: 0.5,
                borderRadius: 1.5,
                color: 'inherit',

                '& .MuiListItemIcon-root': {
                  color: 'inherit',
                },

                '&.Mui-selected': {
                  backgroundColor: 'secondary.main',
                  color: 'secondary.contrastText',
                },

                '&.Mui-selected:hover': {
                  backgroundColor: 'secondary.dark',
                },

                '&:hover': {
                  backgroundColor: 'rgba(255, 255, 255, 0.08)',
                },
              }}
            >
              <ListItemIcon
                sx={{
                  minWidth: 40,
                }}
              >
                {item.icon}
              </ListItemIcon>

			  <ListItemText
			    primary={item.label}
			    slotProps={{
			      primary: {
			        sx: {
			          fontWeight: selected ? 700 : 500,
			        },
			      },
			    }}
			  />
            </ListItemButton>
          );
        })}
      </List>
    </Box>
  );
}

export default AppSidebar;