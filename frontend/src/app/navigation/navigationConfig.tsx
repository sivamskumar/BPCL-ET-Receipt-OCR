import type { ReactNode } from 'react';

import AccountBalanceWalletOutlinedIcon from '@mui/icons-material/AccountBalanceWalletOutlined';
import AdminPanelSettingsOutlinedIcon from '@mui/icons-material/AdminPanelSettingsOutlined';
import AssignmentTurnedInOutlinedIcon from '@mui/icons-material/AssignmentTurnedInOutlined';
import BalanceOutlinedIcon from '@mui/icons-material/BalanceOutlined';
import BusinessOutlinedIcon from '@mui/icons-material/BusinessOutlined';
import DashboardOutlinedIcon from '@mui/icons-material/DashboardOutlined';
import DescriptionOutlinedIcon from '@mui/icons-material/DescriptionOutlined';
import FactCheckOutlinedIcon from '@mui/icons-material/FactCheckOutlined';
import HistoryOutlinedIcon from '@mui/icons-material/HistoryOutlined';
import LocalGasStationOutlinedIcon from '@mui/icons-material/LocalGasStationOutlined';
import ManageAccountsOutlinedIcon from '@mui/icons-material/ManageAccountsOutlined';
import PaymentsOutlinedIcon from '@mui/icons-material/PaymentsOutlined';
import PeopleAltOutlinedIcon from '@mui/icons-material/PeopleAltOutlined';
import PointOfSaleOutlinedIcon from '@mui/icons-material/PointOfSaleOutlined';
import ReceiptLongOutlinedIcon from '@mui/icons-material/ReceiptLongOutlined';
import ReviewsOutlinedIcon from '@mui/icons-material/ReviewsOutlined';
import SecurityOutlinedIcon from '@mui/icons-material/SecurityOutlined';
import SettingsOutlinedIcon from '@mui/icons-material/SettingsOutlined';

import type { UserRole } from '../../types/UserRole';

export type NavigationItem = {
  type: 'item';
  label: string;
  path: string;
  icon: ReactNode;
  roles: UserRole[];
};

export type NavigationGroup = {
  type: 'group';
  label: string;
  icon: ReactNode;
  roles: UserRole[];
  children: NavigationItem[];
};

export type NavigationEntry =
  | NavigationItem
  | NavigationGroup;

export const navigationItems: NavigationEntry[] = [
  {
    type: 'item',
    label: 'Dashboard',
    path: '/app/dashboard',
    icon: <DashboardOutlinedIcon />,
    roles: [
      'EMPLOYEE',
      'REVIEWER',
      'APPROVER',
      'ADMINISTRATOR',
    ],
  },

  // ---------------------------------------------------------------------------
  // Employee Navigation
  // ---------------------------------------------------------------------------

  {
    type: 'item',
    label: 'My Shift',
    path: '/app/shift',
    icon: <ReceiptLongOutlinedIcon />,
    roles: ['EMPLOYEE'],
  },
  {
    type: 'item',
    label: 'Receipts / OCR',
    path: '/app/receipts',
    icon: <DescriptionOutlinedIcon />,
    roles: ['EMPLOYEE'],
  },
  {
    type: 'item',
    label: 'Collections',
    path: '/app/collections',
    icon: <PaymentsOutlinedIcon />,
    roles: ['EMPLOYEE'],
  },
  {
    type: 'item',
    label: 'My Reconciliation',
    path: '/app/reconciliation',
    icon: <BalanceOutlinedIcon />,
    roles: ['EMPLOYEE'],
  },

  // ---------------------------------------------------------------------------
  // Reviewer Navigation
  // ---------------------------------------------------------------------------

  {
    type: 'item',
    label: 'Pending Reviews',
    path: '/app/reviews/pending',
    icon: <ReviewsOutlinedIcon />,
    roles: ['REVIEWER'],
  },
  {
    type: 'item',
    label: 'Review History',
    path: '/app/reviews/history',
    icon: <HistoryOutlinedIcon />,
    roles: ['REVIEWER'],
  },
  {
    type: 'item',
    label: 'Reports',
    path: '/app/reports',
    icon: <FactCheckOutlinedIcon />,
    roles: ['REVIEWER'],
  },

  // ---------------------------------------------------------------------------
  // Approver Navigation
  // ---------------------------------------------------------------------------

  {
    type: 'item',
    label: 'Pending Approvals',
    path: '/app/approvals/pending',
    icon: <AssignmentTurnedInOutlinedIcon />,
    roles: ['APPROVER'],
  },
  {
    type: 'item',
    label: 'Approval History',
    path: '/app/approvals/history',
    icon: <HistoryOutlinedIcon />,
    roles: ['APPROVER'],
  },
  {
    type: 'item',
    label: 'Reports',
    path: '/app/reports',
    icon: <FactCheckOutlinedIcon />,
    roles: ['APPROVER'],
  },

  // ---------------------------------------------------------------------------
  // Administrator Navigation
  // ---------------------------------------------------------------------------

  {
    type: 'group',
    label: 'Organization Setup',
    icon: <BusinessOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
    children: [
      {
        type: 'item',
        label: 'Organization',
        path: '/app/admin/organization',
        icon: <BusinessOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Fuel Stations',
        path: '/app/admin/stations',
        icon: <LocalGasStationOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Shift Definitions',
        path: '/app/admin/shift-definitions',
        icon: <SettingsOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
    ],
  },

  {
    type: 'group',
    label: 'Fuel Configuration',
    icon: <PointOfSaleOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
    children: [
      {
        type: 'item',
        label: 'Fuel Types',
        path: '/app/admin/fuel-types',
        icon: <LocalGasStationOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Fuel Prices',
        path: '/app/admin/fuel-prices',
        icon: <AccountBalanceWalletOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
    ],
  },

  {
    type: 'group',
    label: 'Dispenser Configuration',
    icon: <LocalGasStationOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
    children: [
      {
        type: 'item',
        label: 'Dispenser Units',
        path: '/app/admin/dispenser-units',
        icon: <LocalGasStationOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Dispenser Sides',
        path: '/app/admin/dispenser-sides',
        icon: <SettingsOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Nozzles',
        path: '/app/admin/nozzles',
        icon: <PointOfSaleOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
    ],
  },

  {
    type: 'group',
    label: 'People & Access',
    icon: <PeopleAltOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
    children: [
      {
        type: 'item',
        label: 'Employees',
        path: '/app/admin/employees',
        icon: <PeopleAltOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Users',
        path: '/app/admin/users',
        icon: <ManageAccountsOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Roles',
        path: '/app/admin/roles',
        icon: <AdminPanelSettingsOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
      {
        type: 'item',
        label: 'Station Access',
        path: '/app/admin/station-access',
        icon: <SecurityOutlinedIcon />,
        roles: ['ADMINISTRATOR'],
      },
    ],
  },

  {
    type: 'item',
    label: 'Reports',
    path: '/app/reports',
    icon: <FactCheckOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
  },
  {
    type: 'item',
    label: 'Audit History',
    path: '/app/admin/audit-history',
    icon: <HistoryOutlinedIcon />,
    roles: ['ADMINISTRATOR'],
  },
];