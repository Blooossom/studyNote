import { Calendar, Home, Inbox, Search, Settings } from "lucide-react";
import {Post} from "@/types/post.type.ts";

export const studyCategories = [
  {
    title: "BackEnd",
    url: "#",
    icon: Home,
  },
  {
    title: "FrontEnd",
    url: "#",
    icon: Inbox,
  },
  {
    title: "Database",
    url: "#",
    icon: Calendar,
  },
  {
    title: "Infrastructure",
    url: "#",
    icon: Search,
  },
  {
    title: "CS",
    url: "#",
    icon: Settings,
  },
  {
    title: "Etc",
    url: "#",
    icon: Settings,
  },
];

export const studyTags = [
  { title: "Java", category: "BackEnd" },
  { title: "SpringBoot", category: "BackEnd" },
  { title: "zustand", category: "FrontEnd" },
  { title: "tailwindCSS", category: "FrontEnd" },
  { title: "Docker", category: "Infrastructure" },
  { title: "SQL", category: "Database" },
  { title: "Network", category: "CS" },
  { title: "정보처리기사", category: "Etc" },
];

export const projectsCategories = [
  { title: "2025", url: "#", icon: Calendar },
  { title: "2024", url: "#", icon: Calendar },
  { title: "2023", url: "#", icon: Calendar },
];

export const projectTags = [
  { title: "합천군 군수실 대시보드 구축 사업", category: "2023" },
  { title: "강북구 조기경보 시스템 구축 사업", category: "2023" },
  { title: "거제시 100세 건강 스마트 경로당 구축 사업", category: "2024" },
  {
    title: "거제시 거가대교 출퇴근 차량 할인 시스템 구축 사업",
    category: "2024",
  },
  { title: "남해군 스마트 경로당 구축 사업", category: "2024" },
  { title: "함양군 군수실 대시보드 구축 사업", category: "2024" },
  { title: "하동군 스마트 경로당 구축 사업", category: "2024" },
  { title: "경기도 360 영상센터 구축 사업", category: "2024" },
  { title: "청양군 조기경보 시스템 구축 사업", category: "2025" },
];

export const studyPosts: Post[] = [
  {title: 'zustand를 잘못 쓰고 있었다.', createdTime: '2025년 4월 21일 01시 30분'},
  {title: 'react-query의 키 관리', createdTime: '2025년 4월 21일 01시 30분'},
  {title: 'zod를 활용한 유효성 검사', createdTime: '2025년 4월 21일 01시 30분'},
  {title: 'orval을 통한 codegen', createdTime: '2025년 4월 21일 01시 30분'},
  {title: 'typeScript 의 utility 타입', createdTime: '2025년 4월 21일 01시 30분'},
  {title: 'React-Forget', createdTime: '2025년 4월 21일 01시 30분'},
]