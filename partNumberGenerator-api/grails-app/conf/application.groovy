grails.plugin.springsecurity.rest.token.storage.jwt.secret = 's0m3b1zarr0Secret1$#@%^&*s0m3b1zarr0Secret1$#@%^&*s0m3b1zarr0Secret1$#@%^&*'

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/**',              access: ['permitAll']],

]

//[pattern: '/error',          access: ['permitAll']],
//[pattern: '/index',          access: ['permitAll']],
//[pattern: '/index.gsp',      access: ['permitAll']],
//[pattern: '/assets/**',      access: ['permitAll']],
//[pattern: '/**/js/**',       access: ['permitAll']],
//[pattern: '/**/css/**',      access: ['permitAll']],
//[pattern: '/**/images/**',   access: ['permitAll']],
//[pattern: '/**/favicon.ico', access: ['permitAll']]
//-anonymousAuthenticationFilter,

grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],

        //Traditional, stateful chain
        [
                pattern: '/stateful/**',
                filters: 'JOINED_FILTERS,-restTokenValidationFilter,-restExceptionTranslationFilter'
        ]
]
