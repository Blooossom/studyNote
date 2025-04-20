// orval.config.ts
import { defineConfig } from 'orval';

export default defineConfig({
    studyNoteApi: {
        // ▶ 스펙을 노출하는 서버가 기동 중이어야 합니다.
        input: {
            target: 'http://localhost:8085/studyNote/v3/api-docs',
            validation: false,       // 원격 스펙 검증 불필요 시 false
        },
        output: {
            mode: 'tags',            // OpenAPI 태그별로 분리
            target: 'src/api',
            client: 'react-query',   // React‑Query 훅 생성
            // hooks: {
            //     override: {
            //         useQuery: { suffix: 'Query' },
            //         useMutation: { suffix: 'Mutation' },
            //     },
            // },
            // (선택) 커스텀 페처 사용 예시
            // override: {
            //   mutator: {
            //     path: '../utils/fetcher',
            //     name: 'fetcher',
            //   },
            // },
        },
    },
});