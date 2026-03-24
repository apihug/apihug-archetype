// @formatter:off
package com.apihug.rad.infra.spa;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * SPA (Single Page Application) routing filter template.
 *
 * <p>This class serves as a starting point for implementing client-side routing in reactive Spring applications.
 * Modify the template logic according to your application's routing requirements.
 *
 * <p><strong>Template Instructions:</strong>
 * <ol>
 *   <li>Adjust {@code excludePrefixes} to match your API endpoints and protected paths</li>
 *   <li>Implement {@code resolveIndexPath()} for multi-entry SPA routing if needed</li>
 *   <li>Complete the forwarding logic in {@code filter()} method</li>
 * </ol>
 *
 * <p>The filter runs with the highest priority ({@code @Order(Integer.MIN_VALUE)}) to intercept
 * requests before other filters process them.
 *
 * <p><strong>Default behavior:</strong> Passes all requests through without SPA routing.
 * Implement the commented forwarding logic to enable SPA functionality.
 */
@Order(Integer.MIN_VALUE)
@Generated("H.O.P.E. Infra Team")
public class SpaFilter extends OncePerRequestFilter {
  /**
   * Path prefixes that should bypass SPA routing.
   * Default includes common API endpoints and management interfaces.
   *
   * <p><strong>Customization required:</strong> Update this set to match your application's
   * API endpoints, documentation paths, and administrative interfaces.
   */
  Set<String> excludePrefixes = Set.of("/api", "/management", "/v3/api-docs", "/hope/meta", "/h2-console");

  /**
   *
   * Determines if a request path should bypass SPA routing.
   *
   * <p>Exclusion logic:
   * <ol>
   *   <li>Paths starting with any prefix in {@code excludePrefixes}</li>
   *   <li>Paths containing dots (indicating static resources like .js, .css, .png)</li>
   *   <li>The root path "/"</li>
   * </ol>
   *
   * @param path Request path without context
   * @return true if request should bypass SPA routing, false if it should be handled by SPA
   *
   */
  boolean shouldExclude(String path) {
    // 1. Check for excluded prefixes
    for (String prefix : excludePrefixes) {
      if (path.startsWith(prefix)) {
        return true;
      }
    }
    // 2. Check if path contains a dot (static resources like .js, .css, .png)
    if (path.contains(".")) {
      return true;
    }
    // 3. Allow the root path directly
    return path.equals("/");
  }

  /**
   * Resolves the SPA entry HTML file for the given path.
   *
   * <p><strong>Template implementation:</strong> Currently returns "index.html" for all paths.
   *
   * <p><strong>Customization required:</strong> Implement multi-entry routing logic if your
   * application has multiple SPA entry points (e.g., separate admin and user interfaces).
   *
   * <p>Example implementation:
   * <pre>
   * if (path.startsWith("/admin")) {
   *   return "/admin/index.html";
   * }
   * return "index.html";
   * </pre>
   *
   * @param path Request path without context
   * @return Path to the appropriate SPA entry HTML file
   *
   */
  String resolveIndexPath(String path) {
    //FIXME add your logic
    //if (path.startsWith("/admin")) {
    //      return "/admin/index.html";
    //}
    return "index.html";
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    // 1. Extract the request path relative to the application context
    // This removes the application context prefix (e.g., "/myapp") from the full URI
    // Example: "/myapp/admin/users" becomes "/admin/users"

    String path = request.getRequestURI().substring(request.getContextPath().length());

    // 2. Exclusion check: bypass SPA routing for specific request types
    // This allows API endpoints, static resources, and other non-SPA content
    // to be processed normally by the server

    if (shouldExclude(path)) {
      filterChain.doFilter(request, response);
      return;
    }


    // 3. SPA Routing Logic (To be implemented)
    // -----------------------------------------------------------------
    // UNCOMMENT AND CUSTOMIZE THE FOLLOWING SECTION TO ENABLE SPA ROUTING
    // -----------------------------------------------------------------

    // Option A: Use dynamic path resolution (recommended for multi-entry SPAs)
    // String indexPath = resolveIndexPath(path);
    // request.getRequestDispatcher(indexPath).forward(request, response);

    // Option B: Hard-code a single SPA entry point (simpler setup)
    // request.getRequestDispatcher("/index.html").forward(request, response);

    // -----------------------------------------------------------------
    // TEMPLATE DEFAULT: Pass through without SPA routing
    // -----------------------------------------------------------------
    // This line should be removed or commented out once SPA routing is implemented
    // It currently acts as a pass-through, allowing all requests to proceed normally


    filterChain.doFilter(request, response);

    // -----------------------------------------------------------------
    // Implementation Notes:
    // -----------------------------------------------------------------
    // 1. After implementing SPA routing, remember to:
    //    - Remove or comment out the default pass-through line above
    //    - Uncomment and adjust the appropriate forwarding logic
    //    - Ensure resolveIndexPath() method is properly implemented
    //
    // 2. For multi-tenant or multi-module applications:
    //    - Consider path-based routing to different SPA entry points
    //    - Example: "/admin/*" → "/admin/index.html"
    //               "/app/*"   → "/app/index.html"
    //
    // 3. Important: Forwarding preserves the original request context
    //    - Headers, parameters, and session remain intact
    //    - The forward is internal to the server (client sees original URL)
    //    - Response can be modified by subsequent filters in the chain

  }
}
