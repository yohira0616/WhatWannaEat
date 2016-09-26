var gulp = require('gulp');

gulp.task('default', function () {
    return gulp.src('templates/**/*.html')
        .pipe(gulp.dest('../../../build/resources/main/templates'));
});

gulp.task('static', function () {
    return gulp.src('static/**/*')
        .pipe(gulp.dest('../../../build/resources/main/static'));
});

gulp.task('watch', function () {
    gulp.watch('templates/**/*.html', ['default']);
    gulp.watch('static/**/*', ['static']);

});