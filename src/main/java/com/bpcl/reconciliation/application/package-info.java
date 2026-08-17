/**
 * Application-layer use cases and orchestration.
 *
 * <p>The application layer coordinates domain entities, repositories,
 * validation, execution context and transaction boundaries. It contains
 * application use cases but does not contain HTTP-specific concerns.
 *
 * <h2>Service conventions</h2>
 *
 * <ul>
 *   <li>Application services represent business use cases.</li>
 *   <li>State-changing use cases define transaction boundaries using
 *       {@code @Transactional}.</li>
 *   <li>Read-only use cases use {@code @Transactional(readOnly = true)}
 *       where appropriate.</li>
 *   <li>Controllers must not access repositories directly.</li>
 *   <li>Repositories must not define application-level transaction
 *       boundaries.</li>
 * </ul>
 *
 * <h2>Input and output conventions</h2>
 *
 * <ul>
 *   <li>Use-case inputs use the {@code *Command} naming convention.</li>
 *   <li>Use-case outputs use the {@code *Result} naming convention.</li>
 *   <li>Domain entities are not exposed directly through the API layer.</li>
 *   <li>HTTP request and response models belong to the API layer.</li>
 * </ul>
 *
 * <h2>Layering</h2>
 *
 * <pre>
 * API / Controller
 *       |
 *       v
 * Application Service
 *       |
 *       v
 * Domain / Repository
 *       |
 *       v
 * Persistence
 * </pre>
 *
 * <p>Application services may depend on domain repositories and common
 * application abstractions. The domain layer must remain independent of
 * the application and API layers.
 */
package com.bpcl.reconciliation.application;